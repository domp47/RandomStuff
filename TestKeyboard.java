import java.util.Scanner;
import BasicIO.*;

public class TestKeyboard {
	private static ASCIIDisplayer d;
	public static void main(String[] args) throws InterruptedException {
		d = new ASCIIDisplayer();
		
		d.writeString("your mom");
		
		d = new ASCIIDisplayer();
		
		d.writeString("i like nuggets");
		
		d.close();
		
		d.writeString("Poop nuggets");
		
		d.close();
	
	
	}

}