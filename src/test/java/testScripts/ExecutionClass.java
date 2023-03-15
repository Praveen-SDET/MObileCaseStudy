package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Base.TestingBase;
import Pages.AddcartPage;
import Pages.CartPage;
import Pages.PlaceOrderPage;
import Pages.SignInPage;
import utility.utill;

public class ExecutionClass extends TestingBase {
	ExtentReports reports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	SignInPage sign;
	AddcartPage cate;
	CartPage itemsavail;
	PlaceOrderPage pls;
	
	
	@BeforeTest
	public void setup() {
		initializer();
		reports = new ExtentReports();
		spark = new ExtentSparkReporter("target//SparkReporter.html");
		reports.attachReporter(spark);
	}
 @Test(priority=1 )
  public void login() throws InterruptedException {
	 extentTest=reports.createTest("Signup test");
	 sign=new SignInPage();
	 sign.SigninCret();
//	 cate.cat();
//	 cate.items();
 }
 @DataProvider(name="readdata")
 public Object[][] getData() throws IOException, CsvValidationException{
		String path =System.getProperty("user.dir")+("//src//test//resources//Resources_CX//details_Cx.csv");
		String[] cols;
		CSVReader reader = new CSVReader(new FileReader(path));
		ArrayList<Object> dataList = new ArrayList<Object>();
		while((cols=reader.readNext()) !=null) {
			Object[] record = {cols[0],cols[1]};
			dataList.add(record);
		}
		return dataList.toArray(new Object[dataList.size()][]);
		
	}
 @Test(priority=2,dataProvider="readdata")
 public void addingitemdata(String typecat,String item) {
	 extentTest=reports.createTest("Adding Item test");
	 cate=new AddcartPage();
	 cate.addcart(typecat, item);
 }
 @Test(priority=3,dependsOnMethods ="addingitemdata")
 public void del() throws InterruptedException {
	 extentTest=reports.createTest("Deleting Item test");
	 itemsavail=new CartPage();
	 itemsavail.deletelist();
 }
 @Test(priority=4)
 public void ordering() throws InterruptedException {
	 extentTest=reports.createTest("ordering test");
	 
	 pls=new PlaceOrderPage();
	 pls.place();
 }
 @AfterTest
 public void finishExtent() {
	  reports.flush();
 }
 @AfterMethod
 public void teardown(ITestResult result) {
	  if(ITestResult.FAILURE==result.getStatus()) {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String strPath =utill.getScreenshot(driver);
		  extentTest.addScreenCaptureFromPath(strPath);
	  }
 
 }
 
}
