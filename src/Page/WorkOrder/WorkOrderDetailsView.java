package Page.WorkOrder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Action.Gestures;
import Action.SubMenu;
import Page.ActivitiesView;
import UI.GetBy;
import UI.UI;

public class WorkOrderDetailsView extends UI{
	
	public String WoID;
	public String WODescription;
	public String WOCustomerName;
	public String WOExpectedDate;
	
	private By WorkOrderScrollArea= GetBy.className(Class.ScrollView);
	private By WorkOrderNumber=GetBy.FSId("work_order_view_work_order_number");
	private By TimerStartButton= GetBy.ClassAndText(Class.Button, "Timer Start");
	private By TimerStopButton= GetBy.ClassAndText(Class.Button, "Timer Stop");
	private By ConfirmWorkOrderStartButton= GetBy.ClassAndText(Class.Button, "Confirm Work Order");
	private By CompleteWorkOrderButton= GetBy.ClassAndText(Class.Button, "Complete Work Order");
	private By GetASignature= GetBy.ClassAndText(Class.Button, "Get a signature");
	private By EnterReceiptsButton= GetBy.ClassAndText(Class.Button, "Enter receipts");
	private By ShowStorePhotosButton6= GetBy.ClassAndText(Class.Button, "Show store photos");
	private By ShowActivitiesButton= GetBy.ClassAndText(Class.Button, "Show activities");
	private By PutOnHoldButton= GetBy.ClassAndText(Class.Button, "Put on hold");
	private By LocationHistoryButton= GetBy.ClassAndText(Class.Button, "Location history");
	private By LocationAssetsButton= GetBy.ClassAndText(Class.Button, "Location assets");
	
	private List<WebElement> AllTextInWO;
	
	public WorkOrderDetailsView(){
		if(!ElementExist(WorkOrderNumber, 8))
			 Assert.fail("This is not WorkOrder Page");
		SetAllTextInWO();
		WoID=GetWorkOrderID();
		WODescription=GetWorkDescription();
		WOCustomerName=GetWorkOrderCustomerName();
		WOExpectedDate=GetWorkExpectedDate();
	}
	public WorkOrderDetailsView(int ID){
		if(!ElementExist(WorkOrderNumber, 2))
			 Assert.fail("This is not WorkOrder Page");
		SetAllTextInWO();
		WoID=GetWorkOrderID();
		WODescription=GetWorkDescription();
		WOCustomerName=GetWorkOrderCustomerName();
	}
	private void SetAllTextInWO()
	{
		WebElement WOArea= Find(WorkOrderScrollArea).findElement(GetBy.className(Class.LinearLayout));
		AllTextInWO= WOArea.findElements(GetBy.className(Class.TextView));
	}
	private String GetWorkOrderCustomerName()
	{	
		String CustomerName= GetText(GetBy.ResourceId("com.friendlysol.android:id/work_order_view_customer"));
		System.out.println(CustomerName);
		return CustomerName;
	}
	
	private String GetWorkOrderID()
	{
		WebElement ControlCode= AllTextInWO.get(0);
		System.out.println(ControlCode.getText());
		return ControlCode.getText();
	}
	
	private String GetWorkDescription()
	{
		String CustomerName= GetText(GetBy.ResourceId("com.friendlysol.android:id/work_order_view_work_order_description"));
		System.out.println(CustomerName);
		return CustomerName;
	}
	
	private String GetWorkExpectedDate()
	{
		WebElement WOArea= Find(WorkOrderScrollArea).findElement(GetBy.className(Class.LinearLayout));
		WebElement WorkExpectedArea=WOArea.findElements(GetBy.className(Class.LinearLayout)).get(6);
		String allAll= GetTextFromAllChildren(WorkExpectedArea);
		System.out.println(allAll);
		return allAll;
	}
	public void ScrollDown() {
		Gestures.ScrollToEnd() ;
	}
	
	public void ScrollUp() {
		// TODO Auto-generated method stub
		
	}
	public boolean ButtonIsEnabled(String ButtonText) {
	
		return Find(GetBy.ClassAndText(Class.Button, ButtonText)).isEnabled();
	}
	
	public WorkOrderDetailsViewSubMenu OpenSubMenu() {
		SubMenu.Open();
		return new WorkOrderDetailsViewSubMenu();
	}
	public ActivitiesView ShowActivities() {
		ScrollDown();
		Tap(ShowActivitiesButton);
		return new ActivitiesView();
	}
	public WorkOrdersReceiptsView EnterReceipts(){
		ScrollAndTap(EnterReceiptsButton);
		return new WorkOrdersReceiptsView();
	}
	public void TimerStart(){
		Tap(TimerStartButton);
	}
	public void TimerStop(){
		Tap(TimerStopButton);
	}
	
	public boolean TimerStartIsEnabled(){
		return Find(TimerStartButton).isEnabled();
	}
	public boolean TimerStopIsEnabled(){
		return Find(TimerStopButton).isEnabled();
	}
	
}
