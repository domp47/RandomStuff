import java.util.Scanner;
 
public class TransitiveClosure
{
    private int transitiveMatrix[][];
    private int numberofvertices;
    public static final int INFINITY = 999;
 
    public TransitiveClosure(int numberofvertices)
    {
        transitiveMatrix= new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }
 
    public void transitiveClosure(int adjacencymatrix[][])
    {
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                transitiveMatrix[source][destination] = adjacencymatrix[source][destination];
            }
        }
 
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
        {
            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    if (transitiveMatrix[source][intermediate] + transitiveMatrix[intermediate][destination]
                               < transitiveMatrix[source][destination])
                        transitiveMatrix[source][destination] = transitiveMatrix[source][intermediate] 
                                + transitiveMatrix[intermediate][destination];
                }
            }
        }
 
        for (int source = 1; source <= numberofvertices; source++)
            System.out.print("\t" + source);
 
        System.out.println();
        for (int source = 1; source <= numberofvertices; source++)
        {
            System.out.print(source + "\t");
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                System.out.print(transitiveMatrix[source][destination] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void main(String... arg)
    {
        int numberofvertices;
 
        int[][] adjacency_matrix = {{0,0,0,0,0},{0,0,1,0,1},{0,0,0,0,1},{1,0,0,0,0},{0,1,1,0,0}};
 
//        System.out.println("Enter the Weighted Matrix for the graph");
//        for (int source = 1; source <= numberofvertices; source++)
//        {
//            for (int destination = 1; destination <= numberofvertices; destination++)
//            {
//                adjacency_matrix[source][destination] = scan.nextInt();
//                if (source == destination)
//                {
//                    adjacency_matrix[source][destination] = 0;
//                    continue;
//                }
//                if (adjacency_matrix[source][destination] == 0)
//                {
//                    adjacency_matrix[source][destination] = INFINITY;
//                }
//            }
//        }
 
        System.out.println("The Transitive Closure of the Graph"); 
        TransitiveClosure transitiveClosure = new TransitiveClosure(adjacency_matrix.length-1);
        transitiveClosure.transitiveClosure(adjacency_matrix);
 
//        scan.close();
    }
}