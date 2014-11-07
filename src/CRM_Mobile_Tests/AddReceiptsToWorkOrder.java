package CRM_Mobile_Tests;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.Navigate;
import Action.TestData;
import Page.ReceiptEntryView;
import Page.ReceiptEntryView.ReceiptEntryObject;
import Page.WorkOrder.WorkOrderDetailsView;
import Page.WorkOrder.WorkOrderListView;
import Page.WorkOrder.WorkOrdersReceiptsView;
import UI.CRM_Base;

public class AddReceiptsToWorkOrder extends CRM_Base {
	
	 private WorkOrderListView WorkOrderList;
	 private String WoCustomer=TestData.TestCustomer;
	 private String WODescription="Receipts test";
	 private WorkOrderDetailsView WorkOrder;
	 private WorkOrdersReceiptsView Receipts;
	 
	 @BeforeClass
	    public void setUpSuite() {
		ConnectionWithApplication("AddReceiptsToWorkOrder");
		 WorkOrderList=Navigate.ToWorkOrderList();
		 WorkOrderList.Submenu().Customers(WoCustomer);
		 WorkOrder =WorkOrderList.SelectWorkOrderByDescription(WODescription);
		 Receipts= WorkOrder.EnterReceipts();
	 }
	 	 
	 @Test
	 public void AddPurchaseOrdersToReceipts()
	 {
		 ReceiptEntryObject testEntry=new ReceiptEntryObject();
		 testEntry.quantity="100";
		 testEntry.itemCode="SO2";
		 testEntry.description="test_1";
		 testEntry.price="20";
		 testEntry.suppliers="Amazon";
		 
		 ReceiptEntryView  ReceiptEntry= Receipts.AddPO();
		 ReceiptEntry.SetEntry(testEntry);
		 Receipts.GetAllAmountFromSelectedTab();
		 Screenshot("AddPurchaseOrdersToReceipts");
	 }
	 
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }
}
