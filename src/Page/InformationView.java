package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UI.GetBy;
import UI.UI;

public class InformationView extends UI{
	
	private By  ProccedButton= GetBy.ClassAndText(Class.Button,"Proceed");
	//private By  ProccedButton= By.className(GetBy.Class.Button.toString());

	private By  StatusArea= By.className(Class.LinearLayout.toString());
	private By  InformationNotesArea= GetBy.ClassAndText(Class.TextView,"Version ");
	
	private By  SdCardMemoryInfo= GetBy.ClassAndText(Class.TextView,"You only have 10% of your SD card memory left. Please consider freeing some of it.");
	private By  SdCardMemoryInstalation= GetBy.ClassAndText(Class.TextView,"Please install an SD card. Otherwise you may run out of memory soon.");
	public InformationView()
	{
	 CloseAlerts();
	 if (!UI.ElementExist(ProccedButton,5))
	 Assert.fail("This is not Information Page");
	}
	
	public Menu Procced()
	{
	  UI.Click(ProccedButton);
	  return new Menu();
	}
	
	public void CloseAlerts()
	{
		if (UI.ElementExist(SdCardMemoryInfo,1))  UI.Click(ProccedButton);
		if (UI.ElementExist(SdCardMemoryInstalation,0))  UI.Click(ProccedButton);
		//more alert
	}
	
	public String GetStatusNote()
	{
		WebElement LastFrameLayout=  UI.Finds(By.className(Class.FrameLayout.toString())).get(3);
		WebElement LinearLayout=  LastFrameLayout.findElements(By.className(Class.LinearLayout.toString())).get(2);
		WebElement StatusNote= LinearLayout.findElements(By.className(Class.TextView.toString())).get(1);	
		return StatusNote.getText();
	}
	
	public String GetInformationNote()
	{
		WebElement ScrollView=  UI.Find(By.className(Class.ScrollView.toString()));
		WebElement InformationText=  ScrollView.findElement(By.className(Class.TextView.toString()));
		System.out.println("ii"+InformationText.getText());
		return InformationText.getText();
	}

	public void Screenshot()
	{
		Screenshot("InformationView");
	}
	
}
