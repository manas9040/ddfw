package TestScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelMethod.XcelFunc;

public class TC1 {
	 WebDriver driver;
	@BeforeTest
     public void setup(){
    driver = new FirefoxDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");

	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
}
	  @DataProvider(name="ornghrmlogin")
	    public Object [][] passdata() throws Throwable{
	    	
	   
	  	  XcelFunc xcel = new XcelFunc("C:\\Users\\User\\Downloads\\eclipse-jee-neon-3-win32-x86_64\\eclipse\\seleniumwebdriver\\DDFW\\src\\TestData\\orng.HRM.xlsx");
	  	    int rc = xcel.getRowcount("sheet1");
	  	  Object  data [][]= new Object[rc][2];
	  	   
	  	  
	  	        for (int i =1; i <rc; i++) {
	  	    
	  	    data[i][0] = xcel.getcelldata("sheet1",i,0);
	  	     data[i][1] = xcel.getcelldata("sheet1",i , 1);
	  	     }
	  	        return data;
	    }

	   @Test(dataProvider="ornghrmlogin")
	   public void ornghrmlogin(String un,String pwd) throws InterruptedException, IOException{
	     driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(un);
         driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(pwd);
         driver.findElement(By.id("btnLogin")).click();
         Thread.sleep(3000);
	  
	   }
	   
  	
	        @AfterTest
	    	
	    	public void teardown(){
	          driver.close();
	    	  driver.quit();
	}
	

}
             
	   

	  	   
	    
	
	

