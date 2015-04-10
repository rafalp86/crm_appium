package UI;

import java.sql.Time;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Action.Gestures;

import com.google.common.base.Function;

public class UI extends CRM_Base {

	//dodaæ timeout
	protected static boolean ElementExist(By element,int timeout)
	{
		System.out.println("Wait for " +element + " : "+timeout +"s");
		try
		{
			return WaitForElement(element,timeout);
		}
		catch (WebDriverException ex) {
			System.out.println("Elemet NOT exist :  " +element);
			return false;}
	}
	
	
	protected static void Back()
	{
	 driver.navigate().back();
	 System.out.println("press :Back");
	}
	
	protected static String  ExeciutJS(String arg0,Object arg1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript(arg0, arg1);
	}
	
	protected static String GetTextFromAllChildren(WebElement elemet)
	{
		String temp="";	

		if (elemet== null)
			for (WebElement item : driver.findElements(By.className(Class.TextView.toString())))
				temp+=" "+item.getText();
		else
		for (WebElement item : elemet.findElements(By.className(Class.TextView.toString())))
			temp+=" "+item.getText();

		return temp;
	}
	
	protected static void Tap(By element)
	{  // sprawdziæ dzia³aje click JS
		System.out.println("Click in  " +element);
		driver.findElements(element).get(0).click();
	}
	protected static void  ScrollAndTap(By element) {
		Gestures.ScollTo(element);
		Tap(element);
	}
	protected static void TapIfExist(By element,Integer ... timeout)
	  {
	       if(ElementExist(element, timeout.length>0?timeout[0]:2))
	    	   Tap(element);
	  }
	 
	protected static WebElement Find(By element)
	 {
		System.out.println("Find "+ element);
		return driver.findElements(element).get(0);
	}
	
	protected static List<WebElement> Finds(By element)
	 {
		return driver.findElements(element);
	}
	protected static WebElement FindLast(By element)
	 {
		List<WebElement> elememnts=driver.findElements(element);
		return elememnts.get(elememnts.size()-1);
	}
	
	protected static void WaitAndTap(By element)
	  {	
		WaitForElement(element, 5);
		Tap(element);
	 }
	 
	protected boolean WaitForElement(String Xpath)
	  {	
		  WebDriverWait  wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		return true;
	  }
	  
	protected static boolean WaitForElement(By element,int timeout) 
	  {		
			WebDriverWait  wait = new WebDriverWait(driver,new Long(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			return true;
	  }
	
	 public void WaitForDisappear(final By element)
     {
		 System.out.println("Wait for Disappear :"+ element);
         new WebDriverWait(driver, 60).until( new Function<WebDriver, Boolean>() {
             public Boolean apply(WebDriver driver) {
                 return !ElementExist(element,1);
               }
             } );

     }
	
	 protected static String GetText(By element)
	{
		WebElement Elementtext =driver.findElement(element);
		String text= Elementtext.getAttribute("text");
		System.out.println("Get text :"+text);
		return text;
	}
	
	 
	 public enum Class
	 	{
	    	  Button("android.widget.Button"),
	    	  LinearLayout("android.widget.LinearLayout"),
	    	  TextView("android.widget.TextView"),
	    	  FrameLayout("android.widget.FrameLayout"),
	    	  ScrollView("android.widget.ScrollView"),
	    	  ListView("android.widget.ListView"),
	    	  View("android.view.View"),
	    	  RelativeLayout("android.widget.RelativeLayout"),
	    	  CheckBox("android.widget.CheckBox"),
	    	  EditText("android.widget.EditText"),
	    	  ImageView("android.widget.ImageView"),
	    	  Spinner("android.widget.Spinner"),
	    	  CheckedTextView("android.widget.CheckedTextView");
	    	  	  
	  	    private String displayName;

	  	   Class(String displayName) {
	  	        this.displayName = displayName;
	  	    }

	  	    public String displayName() { return displayName; }

	  	    @Override public String toString() { return displayName; }
	 	}
	public static void SetText(By element, String message) {
		WebElement textBox= Find(element);
		textBox.clear(); textBox.sendKeys(message);
	}
	public static void SetText(WebElement element, String message) {
		element.clear(); element.sendKeys(message);
	}
}
