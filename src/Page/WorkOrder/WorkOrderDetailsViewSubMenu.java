package Page.WorkOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UI.GetBy;
import UI.UI;
import UI.UI.Class;

public class WorkOrderDetailsViewSubMenu extends UI{
	
	private By AddPhoto= GetBy.ClassAndText(Class.TextView, "Add Photo");
	private By ExtendDate= GetBy.ClassAndText(Class.TextView, "Extend Date");
	private By AddActivity= GetBy.ClassAndText(Class.TextView, "Add Activity");
	
	public WorkOrderDetailsViewSubMenu()
	{
		if(!ElementExist(AddPhoto, 2))
				Assert.fail("This is not SubMenu page");
	}

	public boolean ElemetIsVisibleInMenu(String menuItem) {
		return ElementExist(GetBy.ClassAndText(Class.TextView, menuItem),1);
		
	}

	public void AddActivity(String Employee, String Message) {
		By AcceptButton= GetBy.className(Class.Button);
		WaitAndTap(AddActivity);
		WaitForElement(GetBy.Text("Assign activity to Employee"), 5);
		UI.SetText(GetBy.className(Class.EditText),Message);
		Tap(AcceptButton);
		WaitForElement(GetBy.Text("Activity succcessfuly created!"), 5);
		Tap(AcceptButton);
	}
	public void AddPhotoFromCamera()
	{
		By ShutterButton= GetBy.ControlDesc("Shutter button");
		Tap(AddPhoto);
		WaitAndTap(GetBy.Text("Device camera"));
		Screenshot("AddPhoto_ChooseDevice");
		WaitAndTap(GetBy.Text("after job"));
		//WaitAndClick(ShutterButton);
		//Screenshot("AddPhoto_GetPhoto");
		//FindLast(GetBy.className(Class.ImageView)).click();
		//WaitAndClick(GetBy.ClassAndText(Class.Button, "Cancel"));
	}
	
	@SuppressWarnings("deprecation")
	public WorkOrderListView ExtendDate(Date EDate, String ExtendingReason)
	{
		WaitAndTap(ExtendDate);
		
		DateFormat monthf = new SimpleDateFormat("MMM");
		DateFormat dayf = new SimpleDateFormat("dd");
		DateFormat yearf = new SimpleDateFormat("yyyy");
		String Smonth=monthf.format(EDate),Sday=dayf.format(EDate),Syear=yearf.format(EDate);
		System.out.println(Smonth+"/"+Sday+"/"+Syear);
		
		List<WebElement> EditArea= Finds(GetBy.className(Class.EditText));
		SetText(EditArea.get(0), Smonth);
		SetText(EditArea.get(1), Sday);	
		SetText(EditArea.get(2), Syear);	
		Screenshot("WOExtendDateCalender");
		Tap(GetBy.ClassAndText(Class.Button,"Save"));
		SetWOExtendingReason(ExtendingReason);
		return new WorkOrderListView();
	}
    
	private void SetWOExtendingReason(String ExtendingReason)
	{
		By FormTitle= GetBy.ClassAndText(Class.TextView,"WO Extended Date");
		By textArea=GetBy.className(Class.EditText);
		By OKButton=GetBy.ClassAndText(Class.Button,"Ok");
		WaitForElement(FormTitle, 5);
		SetText(textArea, ExtendingReason);
		Screenshot("WOExtendReasonForm");
		Tap(OKButton);
		WaitAndTap(OKButton);
	}
}
