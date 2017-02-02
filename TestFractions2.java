//package TestFractions2;


import Fractions.*;
import BasicIO.*;


/** This class is a program to serve as a testbed for the Fraction interface
  * and the RatioFraction class.
  *
  * @see Fraction
  * @see RatioFraction
  *
  * @author D. Hughes
  *
  * @version 1.0 (Feb. 2016)                                                     */

public class TestFractions2 {
    
    
    private ASCIIDisplayer out;
    
    
    /** The constructor opens tne displayer and preforms the tests.              */
    
    public TestFractions2 ( ) {
        
        Fraction  f, g, h;  // fractions for testing
        int       r;
        
        out = new ASCIIDisplayer();
        
        f = new RatioFraction(1,3);
        g = new RatioFraction(2,3);
        
        h = f.add(g);
        out.writeString("1/3 + 2/3 = ");
        out.writeString(h.toString());
        out.newLine();
        h = f.sub(g);
        out.writeString("1/3 - 2/3 = ");
        out.writeString(h.toString());
        out.newLine();
        h = f.mul(g);
        out.writeString("1/3 * 2/3 = ");
        out.writeString(h.toString());
        out.newLine();
        h = f.div(g);
        out.writeString("1/3 / 2/3 = ");
        out.writeString(h.toString());
        out.newLine();
        
        r = f.compareTo(g);
        out.writeString("1/3 < 2/3 = ");
        out.writeBoolean(r<0);
        out.newLine();
        out.writeString("1/3 = 2/3 = ");
        out.writeBoolean(r==0);
        out.newLine();
        out.writeString("1/3 > 2/3 = ");
        out.writeBoolean(r>0);
        out.newLine();
        
        r = f.compareTo(f);
        out.writeString("1/3 < 1/3 = ");
        out.writeBoolean(r<0);
        out.newLine();
        out.writeString("1/3 = 1/3 = ");
        out.writeBoolean(r==0);
        out.newLine();
        out.writeString("1/3 > 1/3 = ");
        out.writeBoolean(r>0);
        out.newLine();
        
        f = new RatioFraction();
        g = new RatioFraction(1,1);
        h = f.div(g);
        out.writeString("0/1 / 1/1 = ");
        out.writeString(h.toString());
        out.newLine();
        out.writeString("1/1 / 0/1 = ");
        try {
            h = g.div(f);
            out.writeString(h.toString());
        }
        catch ( ZeroDenominatorException e ) {
            out.writeString(" zero denominator");
        };
        out.newLine();
        
        out.close();
        
    }; // constructor
    
    
    public static void main ( String[] args ) { new TestFractions2(); };
    
    
} // TestFractions
