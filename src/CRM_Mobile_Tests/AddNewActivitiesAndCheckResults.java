package CRM_Mobile_Tests;

import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Action.Navigate;
import Action.TestData;
import Page.ActivitiesView;
import Page.WorkOrder.WorkOrderDetailsView;
import Page.WorkOrder.WorkOrderDetailsViewSubMenu;
import Page.WorkOrder.WorkOrderListView;

import org.testng.annotations.Test;
import UI.CRM_Base;

public class AddNewActivitiesAndCheckResults extends CRM_Base {
	
	private WorkOrderListView WorkOrderList;
	private String AssignEmployee="None";
	private String ActivitiesMessage;
	private String WoCustomer=TestData.TestCustomer;
	private String WoDescription="Appium test";
	private Random RandInt= new Random();
	 
	 @BeforeClass(alwaysRun=true)
	    public void setUpSuite()
	 {
		ConnectionWithApplication("AddNewActivitiesAndCheckResults");
		System.out.println("Test :AddNewActivitiesAndCheckResults");
		
	 }
	 @BeforeMethod
	 public void MetodSetUp()
	 {
		 WorkOrderList=Navigate.ToWorkOrderList();
	 }
	 
	@Test
	 public void AddActivitiesBySubMenu()
	 {		 
		 ActivitiesMessage="Activities, Appium test "+ RandInt.nextInt(100000);
		 WorkOrderDetailsView WorkOrder;
		 WorkOrderDetailsViewSubMenu SubMenu;
		 ActivitiesView Activities;
		 String LatestActivities;
		 
		 WorkOrderList.Submenu().Customers(WoCustomer);
		 WorkOrder= WorkOrderList.SelectWorkOrderByDescription(WoDescription);
		 
		 SubMenu= WorkOrder.OpenSubMenu();
		 SubMenu.AddActivity(AssignEmployee,ActivitiesMessage);
		 Activities =WorkOrder.ShowActivities();
		 LatestActivities= Activities.LatestActivities();
		 Screenshot("AddActivitiesBySubMenu");
		 Assert.assertTrue(LatestActivities.contains(ActivitiesMessage),"I:" + LatestActivities+"E:"+ActivitiesMessage);
		 
	 }
	 
	 @Test
	 public void AddActivitiesInActivitisView()
	 {	 
		 ActivitiesMessage="Activities, add in activitis view "+ RandInt.nextInt(100000);
		 WorkOrderDetailsView WorkOrder;
		 ActivitiesView Activities;
		 String LatestActivities;
		 
		 WorkOrderList.Submenu().Customers(WoCustomer);
		 WorkOrder= WorkOrderList.SelectWorkOrderByDescription(WoDescription);
		 
		 Activities =WorkOrder.ShowActivities();
		 Activities.AddActivity(AssignEmployee,ActivitiesMessage);
		 LatestActivities= Activities.LatestActivities();
		 Screenshot("AddActivitiesInActivitisView");
		 Assert.assertTrue(LatestActivities.contains(ActivitiesMessage),"I:" + LatestActivities+"E:"+ActivitiesMessage);
		 
	 }
	 
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }
}
