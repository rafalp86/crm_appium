package CRM_Mobile_Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Page.WorkOrder.WorkOrderDetailsView;
import Page.WorkOrder.WorkOrderDetailsViewSubMenu;
import Page.WorkOrder.WorkOrderListView;
import UI.CRM_Base;
import UI.GetBy;
import UI.UI.Class;

import Action.Navigate;
import Action.SubMenu;

public class DisplayWorkOrderDetails extends CRM_Base {

	private WorkOrderDetailsView WorkOrder;
	private WorkOrderDetailsViewSubMenu WorkOrderSubMenu;
	private int WorkOrderTestID=1234;
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("DisplayWorkOrderDetails");
		System.out.println("Test :DisplayWorkOrderDetails");
		WorkOrder= Navigate.ToFirstWorkOrder();
	 }
	@Test 
	  public void ShouldDisplayProperWoDetalis() 
	    {
		 String IDNotContains="#";
		 String expectedDescription="Phone System Problem";
		 String expectedCustomer="Pioneer Engineering & Environmental Services";
		 
		 Assert.assertFalse(WorkOrder.WoID.contains(IDNotContains), "Wo ID :"+ WorkOrder.WoID);
		 Assert.assertTrue(WorkOrder.WODescription.contains(expectedDescription), "WO description :"+ WorkOrder.WODescription);
		 Assert.assertTrue(WorkOrder.WOCustomerName.contains(expectedCustomer), "WO customer :"+ WorkOrder.WOCustomerName);
		 
		 Screenshot("ShouldDisplayProperWoDetalis");
	    }
	@Test
	 public void ShouldDisplayAllItemInSubMenu() 
	 {
		SubMenu.Open();
		WorkOrderSubMenu= new WorkOrderDetailsViewSubMenu();
		Assert.assertTrue(WorkOrderSubMenu.ElemetIsVisibleInMenu("Add Photo")); 
		Assert.assertTrue(WorkOrderSubMenu.ElemetIsVisibleInMenu("Extend Date")); 
		Assert.assertTrue(WorkOrderSubMenu.ElemetIsVisibleInMenu("Add Activity"));  
		Screenshot("ShouldDisplayAllItemInSubMenu");
		SubMenu.Close();
	 }
	
	@Test
	public void SchouldCheckStatusAllButtonsInPage()
	{
		WorkOrder.ScrollDown();
		Screenshot("SchouldCheckStatusAllButtonsInPage");
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Timer Start"));
		Assert.assertFalse(WorkOrder.ButtonIsEnabled("Timer Stop"));
		Assert.assertFalse(WorkOrder.ButtonIsEnabled("Confirm Work Order"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Complete Work Order"));
		Assert.assertFalse(WorkOrder.ButtonIsEnabled("Get a signature"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Enter receipts"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Show store photos"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Show activities"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Put on hold"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Location history"));
		Assert.assertTrue(WorkOrder.ButtonIsEnabled("Location assets"));
	
		WorkOrder.ScrollUp();	
	}
	
	 @AfterClass
	    public void tearDown() {
		 	CloseConnection();
	    }
}
