package CRM_Mobile_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Action.Navigate;
import Page.Menu;
import UI.CRM_Base;

public class DisplayMainMenu extends CRM_Base {
	
	private Menu AppManu;
	
	 @BeforeClass(alwaysRun=true)
	    public void setUp()
	 {
		 ConnectionWithApplication("DisplayMainMenu");
		 System.out.println("Test :DisplayMainMenu");
		 AppManu= Navigate.ToMainMenu();
	 }
	 @Test 
	 public void ShouldDisplayMainMenu() 
	    {	 		 
		 AppManu.ScrollUp();
		 Assert.assertTrue(AppManu.MenuItemIsPresent("Work order list"));
		 Assert.assertTrue(AppManu.MenuItemIsPresent("Time sheet"));
		 Screenshot("ShouldDisplayMainMenu");
	    }
	 
	 @Test 
	 public void SchouldScrollDownAndDisplayMenuItem() 
	 {
		 AppManu.ScrollDown();
		 Assert.assertTrue(AppManu.MenuItemIsPresent("Configuration"));
		 Assert.assertTrue(AppManu.MenuItemIsPresent("Send us your suggestion"));
		 Screenshot("SchouldScrollDownAndDisplayMenuItem");
	 }
	 
	 @Test 
	 public void ShouldDisplaySubMenu() 
	 {
		 AppManu.ScrollUp();
		 String ExpectedSubMenuContent="Configuration";
		 String ActualSubMenuTextContent= AppManu.Submenu();
		 Screenshot("ShouldDisplaySubMenu");
		 Assert.assertTrue(ActualSubMenuTextContent.contains(ExpectedSubMenuContent));
         AppManu.SubmenuClose();
	 }
	 
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }

}
