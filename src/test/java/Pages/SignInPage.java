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
	@FindBy(xpath="//div//button[contains(text(),'Log in')]")
	WebElement logbtn;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement homebtn;
	WebDriverWait wait;
	 
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
  public AddcartPage SigninCret() throws InterruptedException {
	  wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	  login.click();
	  Thread.sleep(1000);
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	//loginid.sendKeys(prop.getProperty("Username"));
	loginid.sendKeys("Ramann");
//	loginpwd.sendKeys(prop.getProperty("Password"));
	loginpwd.sendKeys("Hanu");
    Thread.sleep(2000);
    wait.until(ExpectedConditions.elementToBeClickable(logbtn)).click();
//	logbtn.click();
	homebtn.click();
	return new AddcartPage();
	
	
	
}

}
