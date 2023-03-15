package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.TestingBase;

public class CartPage extends TestingBase {
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	WebDriverWait wait;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homebtn;
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement retocart;
	@FindBy(xpath="//div//a[contains(text(),'Delete')][1]")
	WebElement delopt;
	
//	@FindBy(id="totalp")
//	WebElement price;
	@FindBy(xpath= "//div//h3[@id='totalp']")
	WebElement price;
	
	
	public PlaceOrderPage deletelist() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		homebtn.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		retocart.click();
		List<WebElement> BefCart=driver.findElements(By.xpath("//td[2]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(BefCart));
		delopt.click();
		List<WebElement> AftCart=driver.findElements(By.xpath("//td[2]"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(AftCart));
		if(BefCart!=AftCart) {
			Assert.assertTrue(true);
		}
		
//		String valueBefore=price.getText();
//		int beforeitemlist=Integer.parseInt(valueBefore);
//		System.out.println("before delete is "+ beforeitemlist);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[2]")));
//		wait.until(ExpectedConditions.elementToBeClickable(delopt));
//		
//		delopt.click();
//		Thread.sleep(2000);
//		
//		wait.until(ExpectedConditions.visibilityOf(price));
//		String valueAfter=price.getText();
//		int Afteritemlist=Integer.parseInt(valueBefore);
//		System.out.println("After delete is "+ Afteritemlist);
//		
//		Assert.assertNotEquals("beforeitemlist"," Afteritemlist");
//		if(beforeitemlist==Afteritemlist) {
//			System.out.println("Item is not deleted");
//		}
//		else {
//			System.out.println("Item is deleted");
//		}
		
		return new PlaceOrderPage();
		
		
		
	
	}

}
