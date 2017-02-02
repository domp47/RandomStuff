package Lab7;


import BasicIO.*;
import Collections.*;


public class Path {
    
    private ASCIIDataFile in;
    private double[][]  dist;
    private double[] dTo;
    private int length;
    
    public Path ( ) {
        in = new ASCIIDataFile();
        int start,fin;
        length = in.readInt();
        int val;
        
        dist = new double[length][length];
        
        for(int y = 0;y < dist.length;y++){
        	for(int x = 0;x<dist[y].length;x++){
        		val = in.readInt();
        		
        		if(val<0)
        			dist[y][x] = Double.MAX_VALUE;
        		else
        			dist[y][x] = val;
        	}
        	
        }
        start = in.readInt();
        fin = in.readInt();

        dTo = new double[length];
        dTo[0] = 0;
        for(int i = 1;i<dTo.length;i++){
        	dTo[i] = Double.MAX_VALUE;
        }
        
        in.close();
        
       distance(start,fin);
        
        for(int i = 0;i<dTo.length;i++){
        	System.out.print(dTo[i]+" ");
        }

    };  // constructor
    
    
    private double distance ( int from, int to ) {
        int y;
    	
        Queue<Integer> q = new LnkQueue<Integer>();
    	
        q.enter(from);
        
        try{
        	while(true){
        		y = q.front();
        		
        		q.leave();
        		
        		for(int i = 0;i<dist[y].length;i++){
        			if(dTo[i]>dist[y][i]+dTo[y]){
        				dTo[i] = dist[y][i]+dTo[y];
        				q.enter(i);
        			}
        		}
        	}
        }
        catch(NoItemException e){}
        
        return dTo[to];
    };  // distance
    
    
    public static void main ( String[] args ) { new Path(); };
    
    
}  // Path
            