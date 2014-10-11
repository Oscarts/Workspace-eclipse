import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.DynamicImplementation;

/**
 * The class <code>Solver</code> is an implementation of a greedy algorithm to solve the knapsack problem.
 */
public class Solver {
	
	protected static ArrayList<Item> data;
	//constructor
	public Solver(){
		data= new ArrayList<Item>();
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
        
        // parse the data in the file
        String[] firstLine = lines.get(0).split("\\s+");
        int items = Integer.parseInt(firstLine[0]);
        int capacity = Integer.parseInt(firstLine[1]);
       // System.out.println(items +"  " + capacity);
        int[] values = new int[items];
        int[] weights = new int[items];
        double[] density=new double[items];
        Solver Sol=new Solver(); //indispensable to create a data arraylist

        for(int i=1; i < items+1; i++){
          String line = lines.get(i);
          String[] parts = line.split("\\s+");

          values[i-1] = Integer.parseInt(parts[0]);
          weights[i-1] = Integer.parseInt(parts[1]);
          density[i-1]=values[i-1]/(double) weights[i-1];
          
          // data contains info abut item, weight, value and density
          data.add(new Item(i-1,weights[i-1], values[i-1],density[i-1]));
          //data.add(new Density(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),values[i-1]/(double) weights[i-1]));
          //System.out.println("-w-"+ weights[i-1]);
        }
        
        int taken[] =new int[items+1];
        BranchAndBound bb= new BranchAndBound(items, data, capacity);
        taken=bb.solve();
        
        //System.out.println("W " + bb.Weight);
      	// prepare the solution in the specified output format
        System.out.println(taken[items]+" 1");
        for(int i=0; i < items; i++){
            System.out.print(taken[i]+" ");
        }      
        System.out.println("");  
        
//        LinearRelaxation LR=new LinearRelaxation(data, items, capacity);
//        taken=LR.solveDiscrete();
//    
//        System.out.println("W " + LR.weight );
//        System.out.println(taken[items]+" 1");
//        for(int i=0; i < items; i++){
//            System.out.print(taken[i]+" ");
//        }      
//        System.out.println("");  
        
//        DynamicProgramming Dprog=new DynamicProgramming(items, capacity, values, weights);
 //       Dprog.solve();
        
        //sol.dynamicProgramming(items, capacity, values, weights);
        //sol.density(items, capacity, density, weights,values); 
    }
}