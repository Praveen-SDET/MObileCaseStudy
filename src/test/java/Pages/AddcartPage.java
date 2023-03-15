package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestingBase;

public class AddcartPage extends TestingBase {
	
	public AddcartPage() {
		PageFactory.initElements(driver, this);
	}
	WebDriverWait wait;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homebtn;
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement addcartbtn;
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement retocart;
	
	
public CartPage addcart(String str1,String str2) {
	wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	
	homebtn.click();
	wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
	String typecat="//div/a[contains(text(),'"+str1+"')]";
	 driver.findElement(By.xpath(typecat)).click();
	 String item ="//a[contains(text(),'"+str2+"')]";
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(item)));
	 driver.findElement(By.xpath(item)).click();
	 addcartbtn.click();
	 wait.until(ExpectedConditions.alertIsPresent());
	 Alert alert=driver.switchTo().alert();
	 alert.accept();
	 
	 retocart.click();
	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[2]")));
	 
	 
	 
	 return new CartPage();
	 
	 
//	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//	  WebElement btn = driver.findElement(By.xpath("//div/a[contains(text(),'Add to cart')]"));
//		wait.until(ExpectedConditions.elementToBeClickable(btn));
//		btn.click();
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
	
	
}
	
}
