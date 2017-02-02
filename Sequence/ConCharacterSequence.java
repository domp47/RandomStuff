package Sequence;

public class ConCharacterSequence implements CharacterSequence {

	private static final long serialVersionUID = -5983940311352795793L;
	private int count;
	private char[] value;

	public ConCharacterSequence() {
		count = 0;
		value = new char[0];
	}

	public ConCharacterSequence(char c) {
		value = new char[1];
		value[0] = c;
		count =1;
	}

	public ConCharacterSequence(CharSequence cs) {
		count = cs.length();
		value = new char[count];
		for(int i = 0;i<cs.length();i++){
			value[i] = cs.charAt(i);
		}
	}

	public ConCharacterSequence(char[] c) {
		count = c.length;
		value = c;
	}

	@Override
	public boolean equals(CharSequence cs) {
		boolean isT = true;

		if (count != cs.length())
			return false;

		for (int i = 0; i < count; i++) {
			if (this.charAt(i) != cs.charAt(i))
				isT = false;
		}
		return isT;
	}

	@Override
	public int compareTo(CharSequence cs) {
		int len1 = count;
		int len2 = cs.length();
		int min = Math.min(len1, len2);

		for (int i = 0; i < min; i++) {
			if (cs.charAt(i) != this.charAt(i))
				return this.charAt(i)-cs.charAt(i);
		}

			return len1 - len2;
	}

	@Override
	public CharacterSequence toLowerCase() {
		
		char[] ca = new char[count];
		
		for(int i = 0;i<count;i++){
			if(this.charAt(i)>=65&&this.charAt(i)<=90){
				ca[i]=(char) (this.charAt(i)+32);
			}
			else{
				ca[i] = this.charAt(i);
			}
		}
		return new ConCharacterSequence(ca);
	}

	@Override
	public CharacterSequence toUpperCase() {
		char[] ca = new char[this.length()];
		
		for(int i = 0;i<this.length();i++){
			if(this.charAt(i)>=97&&this.charAt(i)<=122){
				ca[i]=(char) (this.charAt(i)-32);
			}
			else{
				ca[i] = this.charAt(i);
			}
		}
		return new ConCharacterSequence(ca);
	}

	@Override
	public CharacterSequence trim() {
		
		int s=0,e=this.length()-1;
		String str="";
		int cnt = 0;
		while(cnt<this.length()&&Character.isWhitespace(this.charAt(cnt))){
			cnt++;
		}
		
		if(cnt==this.length())
			return new ConCharacterSequence();
		
		s = cnt;
		cnt = this.length()-1;
		while(Character.isWhitespace(this.charAt(cnt))){
			cnt--;
		}
		e = cnt;
		
		for(int i = s;i<=e;i++){
			str+=this.charAt(i);
		}
		
		return new ConCharacterSequence(str.toCharArray());
	}

	@Override
	public CharacterSequence replace(char oldChar, char newChar) {
		char[] c = new char[this.length()];
		
		for(int i = 0;i<this.length();i++){
			if(this.charAt(i)==oldChar)
				c[i]=newChar;
			else
				c[i]= this.charAt(i);
		}
		return new ConCharacterSequence(c);
	}

	@Override
	public CharacterSequence concat(CharSequence tail) {
		if(tail.length()==0)
			return this;
		char[] newc = new char[this.length()+tail.length()];
		int cnt = 0;
		
		while(cnt < this.length()){
			newc[cnt]= this.charAt(cnt);
			cnt++;
		}
		int i = 0;
		while(i<tail.length()){
			newc[cnt] = tail.charAt(i);
			cnt++;i++;
		}
		return new ConCharacterSequence(newc);
	}

	@Override
	public char charAt(int index) {
		if ((index < 0) || (index >= count)) {
			throw new StringIndexOutOfBoundsException(index);
        }
           return value[index];
	}

	@Override
	public int length() {
		return count;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		char[] c = new char[end-start];
		if(start<0)
			throw new StringIndexOutOfBoundsException(start);
		if(end>=count)
			throw new StringIndexOutOfBoundsException(end);
		if (start>end) 
			 throw new StringIndexOutOfBoundsException(end-start);
		
		int cnt = 0;
		for(int i = start;i<end;i++){
			c[cnt] = value[i];
			cnt++;
		}
		return new ConCharacterSequence(c);
	}
	
	@Override
	public String toString(){
		return new String(value);
	}
	public char[] toCharArray(){
		return value;
	}

}
