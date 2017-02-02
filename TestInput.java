//package FSM;


import BasicIO.*;


public class TestInput {
    
    private ASCIIDataFile   input;
    private ASCIIDisplayer  display;
    
    public TestInput ( ) {
        
        FSM  recognizer;
        
        input = new ASCIIDataFile();
        display = new ASCIIDisplayer();
        
        recognizer = new FSM(input);
        display.writeString(recognizer.toString());
        display.close();
        
    };  // constructor
    
    
    public static void main ( String[] args ) { TestInput t = new TestInput(); };
    
    
}  // TestInput