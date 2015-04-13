package Page.WorkOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Action.Gestures;
import Action.SubMenu;
import UI.GetBy;
import UI.UI;

public class WorkOrderListView extends UI{
	private By WoItem= By.className(Class.RelativeLayout.toString());
	private By WoDate= WoItem.className(Class.RelativeLayout.toString()).className(Class.TextView.toString());
	private By WoHashElemet= WoDate= WoItem.className(Class.RelativeLayout.toString()).className(Class.TextView.toString());;
	private By WoDescriptioArea= WoItem.className("WO WoDescriptioArea");
	private By WaitMessage= GetBy.ClassAndText(Class.TextView, "Please wait...");
	private By CodeElemet=GetBy.FSId("wo_list_work_order_number");
	
	public WorkOrderListView(){
		WaitForLoading();
		 if (!UI.ElementExist(WoDate,5) || !UI.ElementExist(WoHashElemet,1))
				  Assert.fail("This is not Information Page");
		 
		 Screenshot(" WorkOrderList");
	}
	private void WaitForLoading()
	{
		WaitForDisappear(WaitMessage);
	}
	public WorkOrderDetailsView ChooseFirstWorkOrder()
	{
		Tap(WoItem);
		return new WorkOrderDetailsView();
	}
	
	public String GetFirstWorkOrderCode()
	{
	 return GetText(CodeElemet);
	}
	
	public String GetWorkOrderById(int workOrderID)
	{
		WebElement WOItem= Find(WoItem);
		WebElement WoDetalis= WOItem.findElements(By.className(Class.LinearLayout.toString())).get(0);
	 return GetTextFromAllChildren(WoDetalis);
	}
	
	
	public WorkOrderListViewSubMenu Submenu () {
		SubMenu.Open();
		return new WorkOrderListViewSubMenu();
	 }
	
	 public void Screenshot(){
		Screenshot("WorkOrderList");
	 }
	 
	public WorkOrderDetailsView SelectWorkOrderByDescription(String WODescription) {
		By Description = GetBy.ClassAndText(Class.TextView, WODescription);
		Gestures.ScollTo(Description);
		Tap(Description);
		return new WorkOrderDetailsView();
	}
}
