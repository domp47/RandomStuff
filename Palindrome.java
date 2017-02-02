import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIDisplayer;
import Sequence.CharacterSequence;
import Sequence.ConCharacterSequence;

public class Palindrome {
	private ASCIIDataFile in;
	private ASCIIDisplayer d;
	
	public Palindrome(){
		
		in = new ASCIIDataFile();
		d = new ASCIIDisplayer();
		
		while(true){
			String s = in.readLine();
		
			if(in.isEOF()) break;
			
			CharacterSequence cs = new ConCharacterSequence(s.toCharArray());
			
			if(isPalindrome(cs))
				d.writeLine(s+" is a Palindrome.");
			else
				d.writeLine(s+" is not a Palindrome.");
				
		}
		in.close();
		d.close();
	}
	public boolean isPalindrome(CharacterSequence cs){
		cs=cs.trim().toLowerCase();
		
		if(cs.equals(new ConCharacterSequence()))
			return false;
		
		char[] c = new char[cs.length()];
		for(int i = 0;i<cs.length();i++){
			c[cs.length()-i-1]=cs.charAt(i);
		}
		CharacterSequence cs1 = new ConCharacterSequence(c);
		
		return cs.equals(cs1);
	}
	public static void main(String[] args){ new Palindrome();}
}
