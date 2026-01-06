package academy.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import academy.AbstractComponents.Abstractcomp;

import org.openqa.selenium.WebElement;

public class CartPage extends Abstractcomp {
		
		WebDriver driver;
		
		public CartPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//PageFactory 
		@FindBy(xpath = "//*[@class='cartSection']/h3") List<WebElement> cartProductElement;
		@FindBy(xpath = "//button[contains(text(),'Checkout')]") WebElement checkoutElement;
	    
	    public boolean validateCart(String ProductName)
	    {
	    	boolean cartmatch = cartProductElement.stream().anyMatch(c->c.getText().equalsIgnoreCase(ProductName));
	    	return cartmatch;
	    	
	    }
	    
	    public CheckoutPage goToCheckout()
		{
			checkoutElement.click();
			return new CheckoutPage(driver);
	}
}



