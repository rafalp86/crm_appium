package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import UI.UI.Class;

public class GetBy  {
 	 public static By className(Class claseName)
 	 {
 		 return By.className(claseName.toString());
 	 }
	 public static By ClassAndText(UI.Class ClassName, String Text)
     {
         return By.xpath("//"+ClassName.toString()+"[@text='" + Text + "']");
     }
	 public static By ResourceId(String resorceid)
 	 {
		 return By.xpath("//*[@resource-id='" + resorceid + "']");
 	 }
	 
	 public static By FSId(String id)
 	 {
		 return ResourceId("com.friendlysol.android:id/"+id);
 	 }
	 public static By ClassAndTextContains(UI.Class ClassName, String Text)
     {
         return By.xpath("//"+ClassName.toString()+"[contains(text(),'"+Text+"')]");
     }
	 public static By ControlDesc(String desc)
 	 {
		 return By.xpath("//"+Class.ImageView.toString()+"[@content-desc='" + desc + "']");
 	 }   
	//a[contains(text(),\'Video\')]
     public static By Text(String message) {
 		return GetBy.ClassAndText(Class.TextView, message);
 	}
     public static By ButtonClass()
     {
    	return GetBy.className(Class.Button);
     }
     public static By ButtonByText(String buttonText)
     {
    	return ClassAndText(Class.Button,buttonText);
     }
     
     
	}

