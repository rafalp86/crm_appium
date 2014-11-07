package CRM_Mobile_Tests;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.internal.TestResult;

import UI.CRM_Base;

public class Test22  {
	
	@BeforeClass
	    public void setUpSuite()
	 {
		 DateFormat df = new SimpleDateFormat("dd/yyyy");
		  Random RandInt= new Random();
		   Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR,2014);
			 cal.set(Calendar.MONTH,RandInt.nextInt(10+1));
			 cal.set(Calendar.DAY_OF_MONTH, RandInt.nextInt(20+1));
			 Date EDate=cal.getTime();
		 System.out.println(df.format(EDate));
		 
		 DateFormat monthf = new SimpleDateFormat("MMM");
			DateFormat dayf = new SimpleDateFormat("dd");
			DateFormat yearf = new SimpleDateFormat("YYYY");
			String Smonth=monthf.format(EDate),Sday=dayf.format(EDate),Syear=yearf.format(EDate);
		System.out.println(Smonth+"/"+Sday+"/"+Syear);
	 }
	 
	 @Test
	 public static void Testaa()
	 {
		 String a="$ 12";
	 }
	 
	 @AfterMethod
	 public void tearDown(ITestResult result) {
		 if (result.getStatus() == ITestResult.SUCCESS) {
			 try
			 {
			 FileOutputStream out = new FileOutputStream("..\\" + "FAIL"+result.getName() + "_CRM.png");
	           
	            out.close();
			 }catch (Exception ex){}
	
		    }  
	 }
	 @AfterClass
	    public void tearDown() {
		//  System.out.println(result.isSuccess());
		 
	    }
}
