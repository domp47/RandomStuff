//package FSM;


import BasicIO.*;


public class Validator {
    
    
    private BasicForm  form;        // form for input expressions
    private FSM        recognizer;  // FSM to recognize expressions
    
    
    public Validator ( ) {
        
        ASCIIDataFile  fsmData;  // FSM definition
        int            button;   // button pressed
        String         expr;     // expression to validate
        
        fsmData = new ASCIIDataFile();
        recognizer = new FSM(fsmData);
        fsmData.close();
        form = new BasicForm("Validate","Quit");
        setupForm();
        for ( ; ; ) {
            form.clearAll();
            button = form.accept();
        if ( button == 1 ) break;
            expr = form.readString("expr");
            form.writeBoolean("valid",recognizer.recognize(expr));
            form.accept("OK");
        };
        form.close();
        
    };  //constructor
    
    
    private void setupForm ( ) {
        
        form.setTitle("Validator");
        form.addTextField("expr","Expression",20,10,10);
        form.addRadioButtons("valid",false,55,40,"Invalid","Valid");
        form.setEditable("valid",false);
        
    };  // setupForm
    
    
    public static void main ( String[] args ) { Validator v = new Validator(); };
    
    
}  // Validator