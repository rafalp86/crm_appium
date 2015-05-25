package UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class CRM_Base{

	public static Config appConfig = new Config();
	
	
	//protected static WebDriver driver;
	protected static AppiumDriver driver;
	protected  WebDriver ConnectionWithApplication() 
	{ return ConnectionWithApplication("Test");}
	
	//@BeforeSuite
	protected  WebDriver ConnectionWithApplication(String TestName) 
	{   
		
		driver= null;
		try
		{
			driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), Configuration("Test")) {
				
				@Override
				public MobileElement scrollToExact(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public MobileElement scrollTo(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
		}
		catch (Exception ex)
		{
			Assert.fail("Problem with create Webdrive instantion: "+ ex.toString());
		}
		System.out.println("Connect  with application");
		System.out.println("Test :"+TestName);
		//driver.resetApp();
		WaitForApplication();
		return driver;
	}
	
	//@AfterSuite
	protected void CloseConnection()
	{
	
		driver.quit();
		System.out.println("CloseConnection");
	}
	
	protected  void Screenshot(String fileName) {
        try {
        	File ScreenDir=new File("Screenshots");
        	if (!ScreenDir.exists()) ScreenDir.mkdir();
        		
            FileOutputStream out = new FileOutputStream(".\\Screenshots\\"+fileName + "_CRM.png");
            out.write(((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
          
        }
	 }
	@AfterMethod
	protected  void ScreenshotWhenFail(ITestResult result) {
		  if (result.getStatus() == ITestResult.FAILURE) {
		    	Screenshot("FAIL"+result.getName());
		    }   
	}
//This configuration should by taken from configuration file 
    private   DesiredCapabilities Configuration(String testName)
      {		  
   	   DesiredCapabilities capabilities = new DesiredCapabilities();
   	   if(appConfig.getBool("RunLocal"))
   	   {
	   	  // File appDir = new File("C:\\Appium\\APK");
	     //  File app = new File(appDir, "mobile.apk");  
	   	  // capabilities.setCapability("app",app);
   	   }
   	   else
   	   {
   		
   		capabilities.setCapability("app","sauce-storage:CLMMobileClient-release.apk");
   		
   	   }
   	   capabilities.setCapability("name",testName);
       capabilities.setCapability("platformName","Android");       
       //capabilities.setCapability("deviceName","LGOTMS1ab80a");     
       capabilities.setCapability("deviceName","Android Emulator");
       capabilities.setCapability("platformVersion", "4.4");
       capabilities.setCapability("deviceType", "phone");
       
      // capabilities.setCapability("automationName", "appium");
       //capabilities.setCapability("device","appium");    
         
       capabilities.setCapability("app-package", "com.friendlysol.android"); 
       capabilities.setCapability("app-activity", ".activities.StartActivity"); 
         
       return capabilities;
      }

    private void WaitForApplication()
    {
    	int timeout=0;
    	do
    	{
	    	try
	    	{
	    		Thread.sleep(5000);    
	    		if (!UI.Finds(By.xpath("//*")).isEmpty())
	    			return ;    		
	    	}
	    	catch (Exception ex){}
	    	timeout++;	    	
    	} while (timeout <10);
    }
    
}
