package Action;


import java.util.HashMap;
import org.openqa.selenium.By;

import UI.GetBy;
import UI.UI;
import UI.UI.Class;


public class Gestures extends UI {
	public  static void Scroll(double startX,double startY,double endX,double endY)
	 {
		 try
		 {
		 HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		 swipeObject.put("startX", startX);
		 swipeObject.put("startY",startY);
		 swipeObject.put("endX", endX);
		 swipeObject.put("endY", endY);
		 swipeObject.put("duration", 1.9);
		 ExeciutJS("mobile: swipe", swipeObject);
		 }
		 catch (Exception ex )
		 {
			 // know UIAutomation issue  https://groups.google.com/forum/#!topic/appium-discuss/isReHWFsZhs	
		 }	
	 }
	
	//dodac opcje skrolowania 
	public static void ScollTo(By element)
	{
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		for(int i=0;i<15;i++)
		{
			if (ElementExist(element, 0)) break;
			System.out.println("Scroll: h="+((double)FrameSize.height-20)+"w="+(double)FrameSize.width/2);
			Scroll((double)FrameSize.width/2,(double)FrameSize.height-20, (double)FrameSize.width/2, 5.);
		}
	}
	
	public static void ScrollToEnd()
	{
		/*String lastText="";
		String currentText="";
		while(!lastText.equalsIgnoreCase(FindLast(GetBy.className(Class.TextView)).getText()))
			{
			currentText=FindLast(GetBy.className(Class.TextView)).getText();
			System.out.println("C :"+currentText+" L:"+lastText);
			lastText=currentText;
			Scroll(1.,720, 1., 1.);		
			}*/
		String lastText="";
		String currentText="";
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		while(!lastText.equalsIgnoreCase(FindLast(GetBy.className(Class.TextView)).getText()))
			{
			currentText=FindLast(GetBy.className(Class.TextView)).getText();
			System.out.println("C :"+currentText+" L:"+lastText);
			lastText=currentText;
			Scroll((double)FrameSize.width/2,(double)FrameSize.height-20, (double)FrameSize.width/2, 5.);;		
			}
	}
		
}
