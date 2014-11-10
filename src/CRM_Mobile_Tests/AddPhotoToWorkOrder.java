package CRM_Mobile_Tests;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.Navigate;
import Action.TestData;
import Page.ActivitiesView;
import Page.WorkOrder.WorkOrderDetailsView;
import Page.WorkOrder.WorkOrderDetailsViewSubMenu;
import Page.WorkOrder.WorkOrderListView;
import UI.CRM_Base;

public class AddPhotoToWorkOrder extends CRM_Base {

	private WorkOrderListView WorkOrderList;
	private String AssignEmployee="None";
	private String ActivitiesMessage;
	private String WoCustomer=TestData.TestCustomer;
	private String WoDescription="Appium test";
	private Random RandInt= new Random();
	
	 @BeforeClass
	    public void setUpSuite()
	 {
		ConnectionWithApplication("AddPhotoToWorkOrder");
		System.out.println("Test :AddPhotoToWorkOrder");
		
	 }
	 @BeforeMethod
	 public void MetodSetUp()
	 {
		 WorkOrderList=Navigate.ToWorkOrderList();
	 }
	 @Test
	 public void Test()
	 {
		 WorkOrderDetailsView WorkOrder;
		 WorkOrderDetailsViewSubMenu SubMenu;
		 ActivitiesView Activities;
		 String LatestActivities;
		 
		 WorkOrderList.Submenu().Customers(WoCustomer);
		 WorkOrder= WorkOrderList.SelectWorkOrderByDescription(WoDescription);

		 SubMenu= WorkOrder.OpenSubMenu();
		 SubMenu.AddPhotoFromCamera();
		 
		 
	 }
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }
}
