package Assign5;

import java.io.Serializable;
import BasicIO.ASCIIDataFile;

public class ChapImp implements Chap,Serializable {

	private static final long serialVersionUID = 5487727902087797537L;
	private String serial,auth,tittle;
	private int pages;
	private double roy;
	
	
	public ChapImp(ASCIIDataFile in){
				
		serial = in.readString();
		auth = in.readString();
		tittle = in.readString();
		
		pages = in.readInt();
		
		roy = in.readDouble();
	}	
	
	@Override
	public String getSer() {
		return serial;
	}

	@Override
	public String getAuth() {
		return auth;
	}

	@Override
	public String getTit() {
		return tittle;
	}

	@Override
	public int getPages() {
		return pages;
	}

	@Override
	public double getRoyalty() {
		return roy;
	}

}
