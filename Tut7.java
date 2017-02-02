
public class Tut7 {

	static int[][] a;
	static int c = 1;
	public static void main(String[] args) {
		a = new int[3][5];
		
		for(int y = 0;y<a.length;y++){
			for(int x = 0;x<a[y].length;x++){
				a[y][x] = 0;
			}
		}
		
		a[0][4] = 111;
		a[1][0] = 111;
		a[2][0] = 111;
		a[2][1] = 111;
		a[2][2] = 111;
		a[2][4] = 111;
		
		fillCircle1(1,0);
		
		for(int y = 0;y<a.length;y++){
			for(int x = 0;x<a[y].length;x++){
				if(a[y][x]==111)
					System.out.print(". .");
				else
					System.out.print("."+a[y][x]+".");
			}
			System.out.println();
		}
	}
	public static void fillCircle1(int x,int y){
		
		boolean isaCirc;// = false;
		
		try{
			a[y][x]= a[y][x];
			isaCirc = true;
		}
		catch(Exception e){
			isaCirc = false;
		}
		try{
		if(a[y][x] == 111)
			isaCirc = false;
		}
		catch(Exception e){}
		//System.out.println("a at "+y + "and "+x +" is "+isaCirc);
		
		if(isaCirc&&a[y][x]==0){
			
			fillCircle1(x+1,y);
			fillCircle1(x,y+1); 
			a[y][x] = c; c++;
			fillCircle1(x,y-1); 
			fillCircle1(x-1,y);
		}
	}

}
