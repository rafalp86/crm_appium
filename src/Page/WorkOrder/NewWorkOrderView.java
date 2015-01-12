package Page.WorkOrder;

import org.openqa.selenium.By;

import UI.GetBy;
import UI.UI;

public class NewWorkOrderView extends UI {

	private By woDescribe= GetBy.ClassAndText(Class.EditText,"Briefly describe Your problem");
	private By selectPeopleButton= GetBy.ButtonByText("Select people");
	private By issuePriority= GetBy.Text("Not selected"); // Scroll
	private By assignPeople= GetBy.ClassAndText(Class.CheckedTextView, "Rafal  Koszyk");
	private By save= GetBy.ButtonByText("Save");
	
	public NewWorkOrderView SetDescribe(String describe)
	{
		SetText(woDescribe, describe);
		return this;
	}
	
	public NewWorkOrderView SelectPeople()
	{
		Tap(selectPeopleButton);
		ScrollAndTap(assignPeople);
		Back();
		return this;
	}
	
	public NewWorkOrderView SetPriority()
	{
		ScrollAndTap(issuePriority);
	    FindLast(GetBy.className(Class.CheckedTextView)).click();
		return this;
	}
	
	public NewWorkOrderView Save()
	{
		Tap(save);
		return this;
	}
}
