package CRM_Mobile_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.Navigate;
import Page.ActivitiesView;
import Page.WorkOrder.WorkOrderDetailsView;
import Page.WorkOrder.WorkOrderDetailsViewSubMenu;
import Page.WorkOrder.WorkOrderListView;
import UI.CRM_Base;

public class ExtendWorkOrderDate extends CRM_Base {

	private WorkOrderListView WorkOrderList;
	private WorkOrderDetailsViewSubMenu SubMenu;
	private String WoDescription="Appium test";
	private DateFormat df = new SimpleDateFormat("dd/yy");
	private WorkOrderDetailsView WorkOrder;
	private Calendar cal = Calendar.getInstance();
	private Random RandInt= new Random();
	
	 @BeforeClass(alwaysRun=true)
	    public void setUpSuite()
	 {
		ConnectionWithApplication("ExtendWorkOrderDate");
		System.out.println("Test :ExtendWorkOrderDate");
		
	 }
	 @BeforeMethod
	 public void MetodSetUp()
	 {
		 WorkOrder=Navigate.ToWorkOrderByDescription(WoDescription);
	 }
	 @Test
	 public void ShouldExtendWorkOrder()
	 {
		 cal.set(Calendar.YEAR,2014);
		 cal.set(Calendar.MONTH,RandInt.nextInt(10+1));
		 cal.set(Calendar.DAY_OF_MONTH, RandInt.nextInt(20+1));
		 Date EDate=cal.getTime();
		 
		 String ExtendingReason="Test ";
		 System.out.println(df.format(EDate));
		 SubMenu= WorkOrder.OpenSubMenu();
		 WorkOrderList=SubMenu.ExtendDate(EDate, ExtendingReason) ;
		 WorkOrder= WorkOrderList.SelectWorkOrderByDescription(WoDescription);
		
		 Assert.assertTrue( WorkOrder.WOExpectedDate.contains(df.format(EDate)),"Is:"+WorkOrder.WOExpectedDate+" Exp:"+df.format(EDate));
	 }
	 
	@AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }
}
