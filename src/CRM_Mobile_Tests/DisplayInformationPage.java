package CRM_Mobile_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Action.Navigate;
import Page.InformationView;
import UI.CRM_Base;

public class DisplayInformationPage extends CRM_Base {
	
	private  InformationView InformationSite;
	 @BeforeClass
	    public void setUpSuite()
	 {
		ConnectionWithApplication("DisplayInformationPage");
		System.out.println("Test :DisplayInformationPage");
		InformationSite= Navigate.ToInformationPage();
	 }
	 
	 @Test 
	  public void ShouldDisplayInformationPanel() 
	    {
		 String ExpectedStatus="138";
		 String ExpectedInformation="Version 109";

		 Assert.assertTrue(InformationSite.GetStatusNote().contains(ExpectedStatus),"Unexpected :"+InformationSite.GetStatusNote());
		 Assert.assertTrue(InformationSite.GetInformationNote().contains(ExpectedInformation),"Unexpected :"+InformationSite.GetInformationNote());
		 Screenshot("ShouldDisplayInformationPanel");;		 
	    }
	 
	 @AfterClass
	    public void tearDownSuite() {
		  System.out.println("tearDown");
		 CloseConnection();
	    }

}
