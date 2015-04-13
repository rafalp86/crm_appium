package CRM_Mobile_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Action.Navigate;
import Action.SubMenu;
import Page.WorkOrder.WorkOrderListView;
import Page.WorkOrder.WorkOrderListViewSubMenu;
import UI.CRM_Base;

public class DisplayWorkOrderList extends CRM_Base {
	
	private WorkOrderListView WorkOrderList;
	private WorkOrderListViewSubMenu WorkOrderListSubMenu;
	
	 @BeforeClass(alwaysRun=true)
    public void setUp()
 {
	ConnectionWithApplication("DisplayWorkOrderList");
	System.out.println("Test :DisplayWorkOrderList");
	WorkOrderList=Navigate.ToWorkOrderList();
 }
 
 @Test 
  public void ShouldDisplayAnyElmentInList() 
    {
	  String FirstWODetalis	=WorkOrderList.GetFirstWorkOrderCode();
	  System.out.println(FirstWODetalis);
	  Assert.assertTrue(FirstWODetalis.contains("#"), "Elemet '#...' is not visabe");
	  Screenshot("ShouldDisplayAnyElmentInList");
    }
 
// @Test 
 public void ShouldDisplayCorrectContentInWoItem() 
   {
	 int WoID=3187;
	 String expectedWoDate="9/15/14";
	 String expectedDescription="DTMF Problem for outgoing calls";
	 String expectedCustomer="Pioneer Engineering & Environmental Services Store";
	  String WoDetalis	=WorkOrderList.GetWorkOrderById(WoID);
	  System.out.println("WO detalis :"+WoDetalis);
	  Assert.assertTrue(WoDetalis.contains(expectedWoDate));
	  Assert.assertTrue(WoDetalis.contains(expectedDescription));
	  Assert.assertTrue(WoDetalis.contains(expectedCustomer));
	  Screenshot("ShouldDisplayCorrectContentInWoItem");
   }
 
 @Test 
 public void ShouldDisplayAllItemInSubMenu() 
   {
	 SubMenu.Open();
	 WorkOrderListSubMenu= new WorkOrderListViewSubMenu();
	 Assert.assertTrue(WorkOrderListSubMenu.ItemExist("Sorting"),"Sorting isn't displayed in Submenu");
	 Assert.assertTrue(WorkOrderListSubMenu.ItemExist("Add filter"),"Add filter isn't displayed in Submenu");
	 Assert.assertTrue(WorkOrderListSubMenu.ItemExist("Show put on hold"),"Show put on hold isn't displayed in Submenu");
	 Assert.assertTrue(WorkOrderListSubMenu.ItemExist("Switch User"),"Swich User isn't displayed in Submenu");
	 Assert.assertTrue(WorkOrderListSubMenu.ItemExist("Refresh"),"Refresh isn't displayed in Submenu");
	 
	 Screenshot("ShouldDisplayAllItemInSubMenu");
	 
	 WorkOrderList= WorkOrderListSubMenu.Refresh();
   }
 //
	 @AfterClass
	 public void tearDown() {
		
		 	CloseConnection();
	 }
}
