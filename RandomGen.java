import java.util.*;
public class RandomGen {
	public static void main(String[] args){
//		System.out.println((int)(Math.random()*10)+" "+(int)(Math.random()*10)+" "+(int)(Math.random()*10));
		
//		System.out.println("222".compareTo("111"));
	
		int[] x = {1,2,4,5};
		
		int c = -10;
		int spot = Integer.MIN_VALUE;
		List<Integer> l = new ArrayList<Integer>(x.length);
		
		for(int i = 0;i<x.length;i++){
			l.add(x[i]);
		}
		
		
		
		for(int i = 0;i<l.size();i++){
			System.out.print(l.get(i)+" ");
		}
		
		System.out.println();
		
		for(int i = 0;i<l.size();i++){
			if(l.get(i)>=c){
				spot = i;
				break;
			}
		}
		((ArrayList<Integer>) l).ensureCapacity(l.size()+1);
		
		if(spot == Integer.MIN_VALUE)
			l.add(c);
		else
			l.add(spot, c);
		
		for(int lol:l)
			System.out.print(lol+" ");
		
	}
}
