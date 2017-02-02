package Assign5;

import java.text.NumberFormat;
import BasicIO.Formats;
import BasicIO.ReportPrinter;

public class Printer {
	
	private ReportPrinter p;
	private int cnt = 1;
	private int pCount = 1;
	
	public Printer(Book aBook){
		p = new ReportPrinter();
		
		NumberFormat form = Formats.getCurrencyInstance();
		
		p.setTitle(aBook.getName(),"ISBN "+aBook.getISBN()+"          Price "+form.format(aBook.getPrice()));
		p.newLine();
		
		setUp();
		
		for(Chap c:aBook){
			if(c!=null)
				fill(c);
		}
		
		p.close();
	}
	private void setUp(){
		p.addField("ch", "Chapter",7);
		p.addField("ti", "Title",20);
		p.addField("au", "Author",20);
		p.addField("p", "Page",5);
	}
	private void fill(Chap c){
		p.writeInt("ch",cnt);
		p.writeString("ti", c.getTit());
		p.writeString("au",c.getAuth());
		p.writeInt("p",pCount);
		
		cnt++;
		pCount+=c.getPages();
		
		if(pCount%2==0)
			pCount++;
		
	}
}
