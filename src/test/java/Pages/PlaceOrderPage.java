package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.TestingBase;

public class PlaceOrderPage extends TestingBase {
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	WebDriverWait wait;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homebtn;
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement retocart;
	@FindBy(xpath="//div/button[contains(text(),'Place Order')]")
	WebElement placing;
	@FindBy(css="#name")
	WebElement nameplace;
	@FindBy(css="#country")
	WebElement countryplace;
	@FindBy(css="#city")
	WebElement cityplace;
	@FindBy(css="#card")
	WebElement card;
	@FindBy(css="#month")
	WebElement month;
	@FindBy(css="#year")
	WebElement year;
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement pur;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement okbtn;
	@FindBy(xpath="//button[contains(text(),'Thnak you for your purchase!')]")
	WebElement conmsg;
	
	public void place() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		homebtn.click();
		retocart.click();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		placing.click();
		wait.until(ExpectedConditions.elementToBeClickable(placing));
	//	wait.until(ExpectedConditions.elementToBeClickable(pur));
		//wait.until(ExpectedConditions.elementToBeClickable(nameplace));
	//	Thread.sleep(2000);
//		placing.sendKeys(prop.getProperty("placename"));
//		countryplace.sendKeys(prop.getProperty("placecountry"));
//		cityplace.sendKeys(prop.getProperty("placecity"));
//		card.sendKeys(prop.getProperty("placecard"));
//		month.sendKeys(prop.getProperty("placemonth"));
//		year.sendKeys(prop.getProperty("placeyear"));
		Thread.sleep(2000);
		nameplace.sendKeys("Madhivanan");
		countryplace.sendKeys("Indiaa");
		cityplace.sendKeys("California");
		card.sendKeys("654322");
		month.sendKeys("march");
		year.sendKeys("2023");
		pur.click();
		
//		wait.until(ExpectedConditions.textToBePresentInElement(conmsg, "Thank you for your purchase!"));
//		boolean confirm=conmsg.isDisplayed();
//		Assert.assertTrue(confirm);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	//	okbtn.click();
		
		
		
		
		
		
		
		
		
	}

}
