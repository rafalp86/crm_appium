package Page.WorkOrder;

import org.openqa.selenium.By;
import org.testng.Assert;

import UI.GetBy;
import UI.UI;

public class WorkOrderListViewSubMenu extends UI {
	
	private By SortingItem= GetBy.ClassAndText(Class.TextView,"Sorting");
	private By AddFlterItem= GetBy.ClassAndText(Class.TextView,"Add filter");
	private By CustomersItem= GetBy.ClassAndText(Class.TextView,"Customers");
	private By ShowPutOnHoldItem= GetBy.ClassAndText(Class.TextView,"Show put on hold");
	private By ShowPutOnHoldCheckbox= By.className(Class.CheckBox.toString());
	private By SwitchUserItem= GetBy.ClassAndText(Class.TextView,"Switch User");
	private By RefreshItem= GetBy.ClassAndText(Class.TextView,"Refresh");
	
	public WorkOrderListViewSubMenu() {
		if (!UI.ElementExist(SortingItem,2) || !UI.ElementExist(ShowPutOnHoldCheckbox,1))
		Assert.fail("This is not Menu Page");
	}

	public boolean ItemExist(String ItemName){
		return ElementExist( GetBy.ClassAndText(Class.TextView,ItemName),2);
	}
	
	public WorkOrderListView Sorting()
	{
		Click(SortingItem);
		return new WorkOrderListView();
	}
	
	public WorkOrderListView AddFlter()
	{
		Click(AddFlterItem);
		return new WorkOrderListView();
	}
	
	public WorkOrderListView Customers(String CustomerName)
	{
		Click(CustomersItem);
		WaitAndClick(GetBy.ClassAndText(Class.TextView, CustomerName));
		return new WorkOrderListView();
	}
	
	public WorkOrderListView ShowPutOnHold()
	{
		Click(ShowPutOnHoldItem);
		return new WorkOrderListView();
	}
	public WorkOrderListView SwitchUser()
	{
		Click(SwitchUserItem);
		return new WorkOrderListView();
	}
	
	public WorkOrderListView Refresh()
	{
		Click(RefreshItem);
		return new WorkOrderListView();
	}
}
