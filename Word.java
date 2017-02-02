public class Word {
	private String word;
	private int it;
	public Word(String s){
		word = s;
		it = 1;
	}
	public void setIt(int x){
		it = x;
	}
	public void addIt(){
		it++;
	}
	public int getIt(){
		return it;
	}
	public String getWord(){
		return word;
	}
}
