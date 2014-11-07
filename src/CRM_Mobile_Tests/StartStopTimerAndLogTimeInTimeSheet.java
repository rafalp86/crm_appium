package CRM_Mobile_Tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import Page.WorkOrder.WorkOrderDetailsView;
import UI.CRM_Base;

import Action.Navigate;

public class StartStopTimerAndLogTimeInTimeSheet extends CRM_Base {
	private TestResult tr= new TestResult();
	private WorkOrderDetailsView WorkOrder;
	private String WoDescription="Appium test, start /stop time ";
	
	 @BeforeClass
	    public void setUpSuite()
	 {
		ConnectionWithApplication("StartStopTimerAndLogTimeInTimeSheet");
		System.out.println("Test :StartStopTimerAndLogTimeInTimeSheet");
		
	 }
	 @BeforeMethod
	 public void MetodSetUp()
	 {
		 WorkOrder=Navigate.ToWorkOrderByDescription(WoDescription);
	 }
	 @Test
	 public void Test()
	 {
		 WorkOrder.ScrollDown();
		 WorkOrder.TimerStart();
		 Assert.assertFalse(WorkOrder.TimerStartIsEnabled(), "Time should be disabled");	 
	 }
	 
	 @AfterMethod // do wycignicia wyzej
	 public void MetodTearDown(ITestResult result)
	 {
		ScreenshotWhenFail(result);
	 }
	 @AfterClass
	    public void tearDown() {
		   
		 	CloseConnection();
	    }
}
