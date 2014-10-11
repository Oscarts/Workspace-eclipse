import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.DynamicImplementation;
import org.omg.CORBA.INITIALIZE;

/**
 * The class <code>Solver</code> is an implementation of a greedy algorithm to solve the knapsack problem.
 */
public class Solver {
	
	private static ArrayList<Nodes> edges;
	//constructor
	public Solver(){
		edges= new ArrayList<Nodes>();
	}
	
    /**
     * The main class
     */
    public static void main(String[] args) {
        //System.out.println("running \n");
    	try {    
            solve(args);
        } catch (IOException e) {
        	System.out.println("problems in the arguments!");
            e.printStackTrace();
        }
    }
    
    /**
     * Read the instance, solve it, and print the solution in the standard output
     */
    public static void solve(String[] args) throws IOException {
        String fileName = null;
        
        // get the temp file name
        for(String arg : args){
            if(arg.startsWith("-file=")){
                fileName = arg.substring(6);
            } 
        }
        if(fileName == null)
            return;
        
        // read the lines out of the file
        List<String> lines = new ArrayList<String>();
        
        
        BufferedReader input =  new BufferedReader(new FileReader(fileName));
        try {
            String line = null;
            while (( line = input.readLine()) != null){
                lines.add(line);
            }
        }
        finally {
            input.close();
        }
        
        Solver Sol=new Solver(); //indispensable to create a data arraylist
        
        // parse the data in the file
        String[] firstLine = lines.get(0).split("\\s+");
        int nnodes = Integer.parseInt(firstLine[0]);
        int nedges = Integer.parseInt(firstLine[1]);
        
        initializeEdges(nnodes);
       
        int node=0,node2=0;
        
        for(int i=1; i <=nedges; i++){
       
        	String line = lines.get(i);
        	String[] parts = line.split("\\s+");

  			node=Integer.parseInt(parts[0]);
		  	edges.get(node).node=node;
		  	edges.get(node).conections.add(Integer.parseInt(parts[1]));
  			edges.get(node).increaseDegree();
  
  			node2=Integer.parseInt(parts[1]);
  			edges.get(node2).node=node2;
  			edges.get(node2).conections.add(Integer.parseInt(parts[0]));
  			edges.get(node2).increaseDegree();
             
        }
       
        //System.err.println(edges);
        
        int taken[] =new int[nnodes+1];
        ColoringGraphAlgorithm cg= new ColoringGraphAlgorithm( edges, nnodes);
        taken=cg.solve();
        
        
      	// prepare the solution in the specified output format
        System.out.println(taken[nnodes]+" 0 "); // +  nnodes +" density: " + (double) nnodes/nedges);
        for(int i=0; i < nnodes; i++){
            System.out.print(taken[i]-1+" ");
        }      
        System.out.println("");  
        
 }

	private static void initializeEdges(int nnodes) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nnodes; i++) {
			ArrayList<Integer> connetions=new ArrayList<Integer>();
			Nodes n=new Nodes(0, i, connetions);
      	  	edges.add(n);  			
		}
		
	}
}