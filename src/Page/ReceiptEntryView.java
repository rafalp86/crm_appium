package Page;

import org.openqa.selenium.By;

import Action.Gestures;
import UI.GetBy;
import UI.UI;

public class ReceiptEntryView extends UI {
	
	By WaitMessage = GetBy.ClassAndText(Class.TextView, "Retrieving new entry form data. Please wait...");
	By EntryTypeFormTitle = GetBy.ClassAndText(Class.TextView, "Select entry type");
	By SelectButton = GetBy.ClassAndText(Class.Button,"Select");
	By SaveButton = GetBy.ClassAndText(Class.Button,"Save");
	By EditQuantity  =GetBy.ClassAndText(Class.EditText,"Type an amount of the entry here");
	By EditItemCode  =GetBy.ClassAndText(Class.EditText,"");
	By EditDescription  =GetBy.ClassAndText(Class.EditText,"Briefly describe the entry");
	By EditPrice =GetBy.ClassAndText(Class.EditText,"Type a price of the entry unit here");
	By EditSuppliers= GetBy.className(Class.Spinner);
	By Selectsupplier= GetBy.Text("Select supplier");
	
	public ReceiptEntryView(){
		WaitForLoading();	
		if(ElementExist(EntryTypeFormTitle, 1))Click(SelectButton);
	}
	private void WaitForLoading(){
		WaitForDisappear(WaitMessage);
	}
	public void SetEntry(ReceiptEntryObject reo){
		SetText(EditQuantity, reo.quantity);
		SetText(Finds(GetBy.className(Class.EditText)).get(1), reo.itemCode);
		SetText(EditDescription, reo.description);
		Gestures.ScollTo(EditSuppliers);
		SetText(EditPrice, reo.price);
		Click(EditSuppliers);
		WaitForElement(Selectsupplier, 2);
		ScrollAndClick(GetBy.ClassAndText(Class.CheckedTextView, reo.suppliers));
		Screenshot("ReceiptEntryView");
		Click(SaveButton);
	}
	
	
	public static class ReceiptEntryObject
	{
		public String suppliers;
		public String price;
		public String description;
		public String itemCode;
		public String quantity;	
		public ReceiptEntryObject(){}
		public ReceiptEntryObject(String Quantity,String ItemCode,
				String Description,String Price, String Suppliers){
			suppliers=Suppliers;
			price=Price;
			description=Description;
			itemCode=ItemCode;
			quantity=Quantity;	
		}
	}

}
