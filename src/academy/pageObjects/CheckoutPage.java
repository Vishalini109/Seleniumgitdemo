package academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import academy.AbstractComponents.Abstractcomp;

public class CheckoutPage extends Abstractcomp {
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@placeholder='Select Country']") WebElement countryElement;
	@FindBy (css = ".action__submit") WebElement placeOrderElement;
	@FindBy (xpath = "//button[contains(@class,'ta-item')] [2]") WebElement selectcountryElement;
	//@FindBy (xpath = "//html[@lang='en']") WebElement scrollElement;
	
	By countrysuggestionBy =By.cssSelector(".ta-results");
	By placeOrderBtnBy=By.cssSelector(".action__submit");
	
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(countryElement, countryName).build().perform();
		waitForElementToAppear(countrysuggestionBy);
		selectcountryElement.click();
	}
	
	public confirmOrderPage placeOrder() throws InterruptedException
	{
		//waitForElementToAppear(placeOrderBtnBy);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,2500)");
		waitForElementToAppear(placeOrderBtnBy);
		placeOrderElement.click();
		confirmOrderPage confirmOrder = new confirmOrderPage(driver);
		return confirmOrder;

	}
}
