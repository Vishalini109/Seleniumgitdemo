package academy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import academy.testobjects.dataDrivenTestNG;

import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	dataDrivenTestNG dataDrivenTestNG = new dataDrivenTestNG();
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id="userEmail") WebElement useremailElement;
	@FindBy(id="userPassword") WebElement userpasswordElement;
	@FindBy(id="login") WebElement loginbtn;
	
	@Test(dataProvider ="driveTest")
	public ProductCatalog loginapp(String email, String password)
	{
		useremailElement.sendKeys(email);
		userpasswordElement.sendKeys(password);
		loginbtn.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;

	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

}

