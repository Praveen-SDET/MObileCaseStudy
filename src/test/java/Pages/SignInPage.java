package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestingBase;

public class SignInPage extends TestingBase{
	@FindBy(id="login2")
	WebElement login;
	@FindBy(id="loginusername")
	WebElement loginid;
	@FindBy(id="loginpassword")
	WebElement loginpwd;
	//@FindBy(xpath ="(//div/button[@type='button'])[9]")
	//@FindBy(xpath="//div//button[contains(text(),'Log in')]")
	@FindBy(xpath="//div//button[@onclick='logIn()']")
	WebElement logbtn;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement homebtn;
	WebDriverWait wait;
	 
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
  public HomePage SigninCret() throws InterruptedException {
	  wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	  Thread.sleep(3000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//	  homebtn.click();
//	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	//  login.click();
	  wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	  Thread.sleep(3000);
	//  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	//loginid.sendKeys(prop.getProperty("Username"));
	  wait.until(ExpectedConditions.elementToBeClickable(loginid)).sendKeys("Ramann");
//	loginid.sendKeys("Ramann");
//	loginpwd.sendKeys(prop.getProperty("Password"));
	  
	  wait.until(ExpectedConditions.elementToBeClickable(loginpwd)).sendKeys("Hanu");
//	loginpwd.sendKeys("Hanu");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	  Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(logbtn)).click();
//	logbtn.click();
    Thread.sleep(3000);
	homebtn.click();
	return new HomePage();
	
	
	
}

}
