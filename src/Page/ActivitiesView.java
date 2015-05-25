package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Action.Gestures;
import Action.SubMenu;
import UI.GetBy;
import UI.UI;
import UI.UI.Class;

public class ActivitiesView extends UI{
	//com.friendlysol.android:id/li_textview_subject
	private By ActivityText= GetBy.FSId("li_textview_subject");

	public String LatestActivities() {
		System.out.println("Get last Latest Activities");
		Gestures.ScrollToEnd(ActivityText);
		return  FindLast(ActivityText).getText();
	/*	List<WebElement> AllLinearLayout= Finds(GetBy.className(Class.LinearLayout));
		WebElement lastActivities=AllLinearLayout.get(AllLinearLayout.size()-2);// -2 because last is only only Emploer 
		String lastPost=UI.GetTextFromAllChildren(lastActivities);
		return lastPost;
*/
	}
	
	public void AddActivity(String Employee, String Message) {
		SubMenu.Open();
		By AcceptButton= GetBy.className(Class.Button);
		WaitForElement(GetBy.Text("Assign activity to Employee"), 5);
		UI.SetText(GetBy.className(Class.EditText),Message);
		Screenshot("AddActivityView");
		Tap(AcceptButton);
		WaitForElement(GetBy.Text("Activity succcessfuly created!"), 5);
		Tap(AcceptButton);
	}
}
