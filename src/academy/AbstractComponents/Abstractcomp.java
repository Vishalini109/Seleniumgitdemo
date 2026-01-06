package academy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import academy.pageObjects.CartPage;

public class Abstractcomp {
	
	WebDriver driver;

	public Abstractcomp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']") WebElement cartElement;
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementtoDisappear(WebElement disap) throws InterruptedException 
	{
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(disap));
	}
	public CartPage goToCartPage()
	{
		cartElement.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
}
