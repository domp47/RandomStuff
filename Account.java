//package Billing;


import BasicIO.*;


public class Account {
    
	private boolean end=false;
	private String acct,name;// account number, name on account
	private double pre, cur,charge,rate=1.525;// previous reading, current reading, charge amount, rate of charge    
    
    public Account ( ASCIIDataFile data ) {
        
    	acct = data.readString();
		
		if(data.isEOF())
			end = true;
		
		name = data.readString();
		pre = data.readDouble();
		cur = data.readDouble();
        
    };  // constructor
    
    
    public String getAcctNum ( ) {
        
        return acct;
    };  // getAcctNum
    
    
    public String getName ( ) {
        
    	return name;
        
    };  // getName
    
    
    public double getPrevReading ( ) {
        return pre;
        
    };  // getPrevReading
    
    
    public double getCurrReading ( ) {
        return cur;
        
    };  // getCurrReading
    
    
    public void takeReading ( double reading ) {
        cur = reading;
        
    };  // takeReading
    
    
    public double billForUsage ( ) {
    	double bill = (cur-pre) * rate;
    	
    	pre = cur;
    	return bill;
        
    };  // billForUsage
    
    
    public void write ( ASCIIOutputFile to ) {
        to.writeString(acct);
        to.writeString(name);
        to.writeDouble(cur);
        to.newLine();
        
    };  // write
    
    
}  // Account