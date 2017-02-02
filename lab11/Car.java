package lab11;
//package Rental;


import BasicIO.*;


public class Car {
    
    private String lic;
    private int cClass, miles;
    public  static final String[] CAT = {"Economy","Full Size","Van","SUV"};
    private static final double[] RATE = {0.25,0.50,1.00,1.25};
    
    /* Instance Variables */
    
    
    public Car ( ASCIIDataFile in ) {
        lic = in.readString();
        miles = in.readInt();
        cClass = in.readInt();
        
    };  // constructor
    public Car(String s,int m,int c){
    	lic = s;
        miles = m;
        cClass = c;
    }
    
    public String getLicence ( ) {
        return lic;
        
    };  // getLicence
    
    
    public int getMileage ( ) {
        return miles;
        
    };  // getMileage
    
    
    public int getCategory ( ) {
        return cClass;
        	
    };  // getCategory
    
    
    public double getRate ( ) {
        return RATE[cClass];
        
    };  // getRate
    
    
    public double returned ( int m ) {
        int dif = m-miles;
        
        double ch = dif*RATE[cClass];
        miles = m;
        return ch;
        
    };  // returned
    
    
}  // Car