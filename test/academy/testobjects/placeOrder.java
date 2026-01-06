package academy.testobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import academy.pageObjects.CartPage;
import academy.pageObjects.CheckoutPage;
import academy.pageObjects.LoginPage;
import academy.pageObjects.ProductCatalog;
import academy.pageObjects.confirmOrderPage;

public class placeOrder {
	public static void main(String[] args, String email, String password) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String productName="ZARA COAT 3";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo();
		driver.manage().window().maximize();
		ProductCatalog productCatalog = loginPage.loginapp(email,password);
		List <WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		Thread.sleep(3000);
		boolean cartMatch = cartPage.validateCart(productName);
		Assert.assertTrue(cartMatch);
		cartPage.goToCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.selectCountry("India");
		Thread.sleep(2000);
		checkoutPage.placeOrder();
		String finalMessage = confirmOrderPage.verifyConfirmMessage();
		Assert.assertTrue(finalMessage.equalsIgnoreCase(" Thankyou for the order."));
		driver.close();
		}
}
