package Tutorial8;

public class PartA {
    
    public PartA ( ) {
        
        System.out.println(test("stats")); // should be true
        System.out.println(test("nope"));  // should be false
        System.out.println(test("sstatss"));  // should be false
        System.out.println(test("cbc")); // should be true
//    	System.out.println(reverseString("nope"));
    }
    
    public boolean test(String s) {
        return (removeDuplicates(s).equals(s)/**2**/ &&/**1**/ reverseString(s).equals(s));
    }
    
    private String removeDuplicates(String word) {
        if(word == null || word.length() <= 1)
            return word;
        
        else if( word.charAt(0) == word.charAt(1) )
            return removeDuplicates(word.substring(1, word.length()));
        else
            return word.charAt(0) + 
            removeDuplicates(word.substring(1, word.length()));
    }
    
    private String reverseString(String word) {
    	if(word == null || word.equals(""))
            return word;
        else{
            return reverseString(word.substring(1, word.length())) +  word.substring(0/**3**/,1);
    	}
    }
    
    public static void main(String[] args) { PartA p = new PartA(); };
        
} 