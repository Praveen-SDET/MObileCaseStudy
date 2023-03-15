package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingBase {
	public static Properties prop =null;
	public static WebDriver driver=null;
	
	public TestingBase() {
		
		String path=System.getProperty("user.dir")+"//src//test//resources//ConfigFiles//details.properties";
		prop =new Properties();
		FileInputStream fin;
		try {
			fin = new FileInputStream(path);
			prop.load(fin);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			 e.printStackTrace();
			
		}
		
		
	}
public static void initializer() {
//	String strBrowser=prop.getProperty("browser");
//	if(strBrowser.equalsIgnoreCase("chrome")) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		}
	String strBrowser=prop.getProperty("browser1");
	if(strBrowser.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.get(prop.getProperty("url"));
	
}


}
