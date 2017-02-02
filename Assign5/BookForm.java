package Assign5;

import BasicIO.BasicForm;
import BasicIO.Formats;

public class BookForm {
	
	private BasicForm f;
	private boolean print;
	public BookForm(Book aBook){
		f = new BasicForm();
		
		f.addTextField("is", "ISBN",10);
		f.setEditable("is", false);
		f.addTextField("ti", "Title",25);
		f.setEditable("ti", false);
		f.addTextField("ch", "Chapters",3);
		f.setEditable("ch", false);
		f.addTextField("p", "Pages",3);
		f.setEditable("p", false);
		f.addTextField("pr", "Price",Formats.getCurrencyInstance(),8);
		f.setEditable("pr", false);
		
		f.writeString("is", aBook.getISBN());
		f.writeString("ti", aBook.getName());
		f.writeInt("ch", aBook.getNumChap());
		f.writeInt("p",aBook.getNumPages());
		f.writeDouble("pr", aBook.getPrice());
		
		int x = f.accept("Print","Skip");
		
		if(x == 0)
			print = true;
		else 
			print = false;
		
		f.close();
	}
	public void close(){
		f.close();
	}
	public boolean getPrint(){
		return print;
	}
}
