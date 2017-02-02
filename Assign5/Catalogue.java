package Assign5;

import java.io.IOException;
import java.io.Serializable;
import BasicIO.*;

public class Catalogue implements Serializable {
	
	private static final long serialVersionUID = 577963819284292096L;
	private ASCIIDataFile in;
	private BinaryDataFile bIn;
	private BinaryOutputFile out;
	private int numOfChap,numOfBooks;
	
	public Catalogue(Book b){
		
		bIn = new BinaryDataFile();
		out = new BinaryOutputFile();
		
		numOfBooks = bIn.readInt()+1;
		
		out.writeInt(numOfBooks);
		out.writeObject(b);
		
		for(int i = 1;i<numOfBooks;i++){
			out.writeObject((Book)bIn.readObject());
		}
		
		numOfChap = bIn.readInt();
		
		out.writeInt(numOfChap);

		for(int i = 0;i<numOfChap;i++){
			out.writeObject((Chap)bIn.readObject());
		}
		
		bIn.close();
		out.close();
	}
	
	public Catalogue() {
		in = new ASCIIDataFile();
		out = new BinaryOutputFile();
		
		numOfChap = in.readInt();

		out.writeInt(0);
		out.writeInt(numOfChap);
		
		for(int i = 0;i<numOfChap;i++){
			out.writeObject(new ChapImp(in));
		}
		
		in.close();
		out.close();
	}
	public static void main(String args[]) throws IOException{
		new Catalogue();
		System.exit(0);
	}
}
