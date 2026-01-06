package academy.pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import academy.AbstractComponents.Abstractcomp;

import org.openqa.selenium.WebElement;

public class ProductCatalog extends Abstractcomp{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory 
	@FindBy(css = ".mb-3")List<WebElement> productsElement;
	@FindBy(css=".ng-animating") WebElement toastdisappearElement;
	
	By productsElementBy = By.cssSelector(".mb-3");
	By addToCartBy = By.xpath("//button[text()=' Add To Cart']");
	By toastSuccessBy =By.xpath("//div[@id='toast-container']");
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsElementBy);
		return productsElement;
		
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prodElement = getProductList().stream().filter(p->p.findElement(By.cssSelector("b")).
				getText().equals(productName)).findFirst().orElse(null);
		return prodElement;
	}
	
    public void addProductToCart(String productName) throws InterruptedException
    {
		WebElement prodElement=getProductByName(productName);
    	prodElement.findElement(addToCartBy).click();
    	waitForElementToAppear(toastSuccessBy);
    	waitForElementtoDisappear(toastdisappearElement);
    }
    
}

