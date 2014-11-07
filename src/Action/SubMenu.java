package Action;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UI.GetBy;
import UI.UI;
import UI.UI.Class;


public class SubMenu extends UI {
	
	 public static void Open () {
		 WaitForElement(GetBy.className(Class.View),5);
		 WebElement SubMenuView= Find(By.className(Class.View.toString()));
		 WebElement SubMenuButton=SubMenuView.findElements(By.className(Class.TextView.toString())).get(1);
		 SubMenuButton.click();
		 //WaitForElement(By.className(Class.RelativeLayout.toString()), 2);
	 }
	 
	 public static void Close () {
		try
		{
			 HashMap<String, Integer> tapObject = new HashMap<String, Integer>();
			 tapObject.put("x", 10); 
			 tapObject.put("y", 150); 
			 ExeciutJS("mobile: tap", tapObject);
			 System.out.println("Close Sublemu");
		}
		catch (Exception ex)
		{
		System.out.println("TAP exception");
		}
	 }

}
