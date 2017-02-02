package Assign5;

public interface Book extends Iterable<Chap>{
	
	public String getName();
	
	public String getISBN();
	
	public int getNumChap();
	
	public int getNumPages();
	
	public Chap getChap(String Ser);
	
	public double getPrice();
}
