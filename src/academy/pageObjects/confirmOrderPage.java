package academy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import academy.AbstractComponents.Abstractcomp;

public class confirmOrderPage extends Abstractcomp{

	WebDriver driver;
	public confirmOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*@FindBy(xpath="//h1[@class='.hero-primary']")
	static
	WebElement confirmMessagElement;*/
	@FindBy(css="h1[class='hero-primary']")
	static
	WebElement confirmMessagElement2;
	
	
	public static String verifyConfirmMessage()
	{
		return confirmMessagElement2.getText();
	}
}
