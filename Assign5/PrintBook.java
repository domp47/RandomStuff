package Assign5;

import java.io.Serializable;
import BasicIO.BasicForm;
import BasicIO.BinaryDataFile;

public class PrintBook implements Serializable {
	
	private static final long serialVersionUID = 2669637665187207080L;
	private BinaryDataFile in;
	
	public PrintBook(){
		in = new BinaryDataFile();
		
		int nBooks = in.readInt();
		
		for(int i = 0;i<nBooks;i++){
			Book b = (Book) in.readObject();
			
			BookForm f = new BookForm(b);
			
			if(f.getPrint()){
				new Printer(b);
				return;
			}
		}
		
		in.close();
		
		BasicForm dis = new BasicForm();
		
		dis.writeString("No other books in catalogue.");
		
		dis.close();
	}
	public static void main(String[] args){
		new PrintBook();
		System.exit(0);
	}
}
