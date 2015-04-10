package Page;

import java.util.HashMap;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.remote.*;

import Action.Gestures;
import Action.SubMenu;
import Page.WorkOrder.WorkOrderListView;
import UI.GetBy;
import UI.UI;

public class Menu extends UI {
	private By WorkOrderListItem= GetBy.ClassAndText(Class.TextView,"Work order list");
	private By TimeSheetItem= GetBy.ClassAndText(Class.TextView,"Time sheet");
	private By ClientListItem= GetBy.ClassAndText(Class.TextView,"Client list");
	private By CalenderEventsItem= GetBy.ClassAndText(Class.TextView,"Calendar events");
	private By VendorStatisticItem= GetBy.ClassAndText(Class.TextView,"Vendor statistics");
	private By PhotoListItem= GetBy.ClassAndText(Class.TextView,"Photo list");
	
 public Menu()
 {
	 if (!UI.ElementExist(WorkOrderListItem,2))
	  Assert.fail("This is not Menu Page");
 }
 
 public boolean MenuItemIsPresent(String menuItemText)
 {
	 return UI.ElementExist(GetBy.ClassAndText(Class.TextView, menuItemText),1);
 }
 public WorkOrderListView ChooseWorkOrderList()
 {
	 UI.WaitAndTap(WorkOrderListItem) ;
	 return new WorkOrderListView();
 }
 
 public void ChooseTimeSheet()
 {
	 UI.WaitAndTap(TimeSheetItem) ;
 }
 
 public void ChooseClientList()
 {
	 UI.WaitAndTap(ClientListItem) ;
 }
 public void ChooseCalenderEvents()
 {
	 UI.WaitAndTap(CalenderEventsItem) ;
 }
 public void ChooseVendorStatistic()
 {
	 UI.WaitAndTap(By.className("test")) ;
 }
 
 public void ScrollDown()
 {
	Gestures.ScrollToEnd();
 }
 
 public void ScrollUp()
 {
	Gestures.Scroll(100.,200.,100.,300.);
 }
 
 public String Submenu () {
	
	 SubMenu.Open();
	 System.out.println("Open Sublemu");
	return  GetText(By.className(Class.TextView.toString()));
 }
 
 public void SubmenuClose()
 {
	SubMenu.Close();
 }

}
