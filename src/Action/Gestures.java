package Action;


import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;

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
			
		 /*HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		 swipeObject.put("startX", startX);
		 swipeObject.put("startY",startY);
		 swipeObject.put("endX", endX);
		 swipeObject.put("endY", endY);
		 swipeObject.put("duration", 1.9);*/
			 TouchAction action = new TouchAction((MobileDriver) driver);
			 action.press((int)startX, (int)startY).waitAction(500).moveTo((int)endX, (int)endY).release().perform();
	    //TouchShortcuts.c Swip((int)startX,(int)startY,(int)endX,(int)endY);
		// ExeciutJS("mobile: swipe", swipeObject);
		 }
		 catch (Exception ex )
		 {
			 // know UIAutomation issue  https://groups.google.com/forum/#!topic/appium-discuss/isReHWFsZhs	
		 }	
	 }
	
	//dodac opcje skrolowania 
	public static void ScollTo(By element)
	{
		System.out.println("Scroll to :"+element);
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		for(int i=0;i<15;i++)
		{
			if (ElementExist(element, 0)) break;
			System.out.println("Scroll: h="+((double)FrameSize.height-50)+"w="+(double)FrameSize.width/2);
			Scroll((double)FrameSize.width/2,(double)FrameSize.height-50, (double)FrameSize.width/3, 5.);
			sleep(500);  
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
			Scroll((double)FrameSize.width/2,(double)FrameSize.height-50, (double)FrameSize.width/2, 5.);	
			}*/
		String lastText="";
		String currentText="";
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		while(!lastText.equalsIgnoreCase(FindLast(GetBy.className(Class.TextView)).getText()))
			{
			currentText=FindLast(GetBy.className(Class.TextView)).getText();
			System.out.println("C :"+currentText+" L:"+lastText);
			lastText=currentText;
			Scroll((double)FrameSize.width/2,(double)FrameSize.height-50, (double)FrameSize.width/2, 5.);;		
			}
	}
	
	private static void sleep(int milSec)
	{
		try {
			Thread.sleep(milSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
	}
		
}
