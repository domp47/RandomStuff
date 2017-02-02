package Assign5;

import BasicIO.BasicForm;
import BasicIO.Formats;

public class BookCreateForm {
	private BasicForm f;
	private Book aBook;
	public BookCreateForm(Book aBook){
		f = new BasicForm();
		
		this.aBook = aBook;
		
		f.addTextField("is", "ISBN",10);
		f.setEditable("is", true);
		f.addTextField("ti", "Title",25);
		f.setEditable("ti", true);
		f.addTextField("ch", "Chapters",3);
		f.setEditable("ch", false);
		f.addTextField("p", "Pages",3);
		f.setEditable("p", false);
		f.addTextField("pr", "Price",Formats.getCurrencyInstance(),8);
		f.setEditable("pr", false);
				
		update();
	}
	public void update(){
		f.clearAll();
		f.writeString("is", aBook.getISBN());
		f.writeString("ti", aBook.getName());
		f.writeInt("ch", aBook.getNumChap());
		f.writeInt("p",aBook.getNumPages());
		f.writeDouble("pr", aBook.getPrice());

	}
	public void close(){
		f.close();
	}
	public void hide(){
		f.hide();
	}
	public void show(){
		f.show();
	}
	public boolean getDone(){
		int but;
		
		update();
		but = f.accept("Add Chapter","Done");
		return but==1;
	}
	public String getIS(){
		return f.readString("is");
	}
	public String getTit(){
		return f.readString("ti");
	}
}
