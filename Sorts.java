
public class Sorts {
	public static void main(String [] args){
		
		int[] x = {7,2,1,6,4};
		
		BubbleSort(x);
	}
	public static void BubbleSort(int[] intArray){
		 int n = intArray.length;
         int temp = 0;
        
         for(int i=0; i < n; i++){
                 for(int j=1; j < (n-i); j++){
                        
                         if(intArray[j-1] > intArray[j]){
                                 //swap the elements!
                                 temp = intArray[j-1];
                                 intArray[j-1] = intArray[j];
                                 intArray[j] = temp;
                         }
                         for(int ii = 0;ii<n;ii++){
                        	 System.out.print(intArray[ii]+" ");
                         }
                         System.out.println();
                        
                 }
         }
	}
}
