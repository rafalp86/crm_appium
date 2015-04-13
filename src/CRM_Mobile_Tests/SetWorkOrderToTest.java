package CRM_Mobile_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Action.Navigate;
import Action.TestData;
import Page.Menu;
import Page.WorkOrder.NewWorkOrderView;
import Page.WorkOrder.WorkOrderListView;
import Page.WorkOrder.WorkOrderListViewSubMenu;
import UI.CRM_Base;

public class SetWorkOrderToTest extends CRM_Base {

	private WorkOrderListViewSubMenu WorkOrderListSubMenu;
	private NewWorkOrderView NewWorkOrderPage;
	
	 @BeforeClass(alwaysRun=true)
	    public void setUp()
	 {
		 ConnectionWithApplication("SetWorkOrderToTest");
		 System.out.println("Test :SetWorkOrderToTest");
		 WorkOrderListSubMenu = Navigate.ToWorkOrderList().Submenu();
	 }
	 
	 @Test
	 public void SetWorkOrdersTest()
	 {
		 boolean WorkOrderExists= WorkOrderListSubMenu.CustomersExist(TestData.TestCustomer);
		 System.out.println(TestData.TestCustomer+" :"+WorkOrderExists);
		 
		 if (WorkOrderExists) return ;
		 
		 NewWorkOrderPage=Navigate.ToNewWorkOrderView();
		 NewWorkOrderPage.SetDescribe("Appium test").SelectPeople().SetPriority();//Add save
		 NewWorkOrderPage=Navigate.ToNewWorkOrderView();
		 NewWorkOrderPage.SetDescribe("Receipts test").SelectPeople().SetPriority();//Add save
		 NewWorkOrderPage=Navigate.ToNewWorkOrderView();
		 NewWorkOrderPage.SetDescribe("Appium test, start /stop time ").SelectPeople().SetPriority();//Add save
	
		 
		 
	 }
	 
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }

}
