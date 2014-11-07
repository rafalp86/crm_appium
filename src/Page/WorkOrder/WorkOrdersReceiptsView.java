package Page.WorkOrder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Action.Gestures;
import Action.SubMenu;
import Page.ActivitiesView;
import Page.ReceiptEntryView;
import Page.WorkOrder.WorkOrdersReceiptsView;
import UI.GetBy;
import UI.UI;
import UI.UI.Class;

public class WorkOrdersReceiptsView extends UI {
	
	private By AllListTab= GetBy.Text("All list");
	private By AllCostsTab= GetBy.Text("All costs");
	private By PurchaseOrdersTab= GetBy.Text("Purchase Orders");
	private By MaterialsTab= GetBy.Text("Materials");
	private By EquipmentTab= GetBy.Text("Equipment");
	private By ToolsTab= GetBy.Text("Tools");
	private By AddButton= GetBy.ButtonClass();
	private By ListView= GetBy.className(Class.ListView);
	
	private By AlertHeader= GetBy.Text("No receipts");
	private By OKButton= GetBy.ClassAndText(Class.Button, "OK");
	
	public WorkOrdersReceiptsView()
	{
		CloseAlert();
		if(!ElementExist(AllListTab, 2))
			 Assert.fail("This is not Receipts Page");
	}
	
	public ReceiptEntryView AddPO(){
		AddReceipt(PurchaseOrdersTab,"Add PO");
		return new ReceiptEntryView();
	}
	public ReceiptEntryView AddMaterial(){
		AddReceipt(MaterialsTab,"Add material");
		return new ReceiptEntryView();
	}
	public ReceiptEntryView AddEquipment(){
		AddReceipt(EquipmentTab,"Add equipment");
		return new ReceiptEntryView();
	}
	public ReceiptEntryView AddTool(){
		AddReceipt(ToolsTab,"Add tool");
		return new ReceiptEntryView();
	}
	
	private void AddReceipt(By tab,String buttonText){
		Click(tab);
		WaitAndClick(GetBy.ClassAndText(Class.Button ,buttonText));
	}
	
	public void GetAllAmountFromSelectedTab(){
		WaitForElement(ListView, 3);
		List<WebElement> AllVisableItem = Finds(By.xpath("//"+Class.ListView.toString()+"/"+Class.LinearLayout.toString()));
		System.out.println(AllVisableItem.size());
		Gestures.ScrollToEnd();
		AllVisableItem.addAll(Finds(By.xpath("//"+Class.ListView.toString()+"/"+Class.LinearLayout.toString())));
		System.out.println(AllVisableItem.size());
		for(WebElement item :AllVisableItem)
		{
			GetItemCodeAndAmount(item);
		}
	}
	private int[] GetItemCodeAndAmount(WebElement item){
		List<WebElement> allTextInItem=Finds(GetBy.className(Class.TextView));
		int textCount=allTextInItem.size();
		System.out.println("textCount:"+textCount);
		String Number=allTextInItem.get(1).getText();
		String Amount=allTextInItem.get(textCount-1).getText().replace("$ ", "");
		System.out.println("Number:"+Number+" Amount "+Amount);
		return new int[]{};//{new Integer(Number),new Integer(Amount)};
	}
	private void CloseAlert()
	{
		if (ElementExist(AlertHeader, 0))
			Click(OKButton);
	}
}
