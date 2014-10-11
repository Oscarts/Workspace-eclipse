import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


public class BranchAndBound {
	
	private int[] taken;
	private int items;
	public int Weight;
	protected ArrayList<Item> knapsack;
	protected ArrayList<Solution> solutions;
	public int range=2; // represent the range of values that the discrete variable can have. 2, is for binary {0,1}
	LinearRelaxation LR;
	
	/*
	 * Constructor
	 */
	public BranchAndBound(int items, ArrayList<Item> knapsack, int capacity) {
		this.knapsack=new ArrayList<Item>();
		this.solutions=new ArrayList<Solution>();
		taken=new int[items+1];
		this.items=items;
		this.knapsack=knapsack;	
		LR=new LinearRelaxation(knapsack, items, capacity);
		this.solutions=new ArrayList<Solution>();
		this.Weight=0;
	}
	
	public int[] solve() {
		
		Collections.sort(knapsack);
		
		//System.out.println(data);  //Print all list
		int bound=0;
    	int  weight=0;
    	int  value=0;
    	int item=-1;
    	int alelo=-1;
    	int state=0;
    	int cont1=0, cont3=0;
    	
    	Solution Sol=new Solution(item, weight, value, alelo, state, bound);
    	bound=LR.solveLinear(Sol);
    	Sol.setBound(bound);
    	solutions.add(Sol);
    	
    	Sol=getMaxBound(0);
    	
    	while (Sol!=null) {
    		//System.out.println("While"+" cont1:" +cont1+ " cont3:"+cont3 + "Sol" + Sol+ "gen" + Sol.getGen());
			Item d;
			if (Sol.item.isEmpty()) {
				 d=knapsack.get(0);
			}else{
				 d=nextItem(Sol.item.get(Sol.item.size()-1)); 
			}
			
			for ( int i = 0; i < range; i++) {
				Solution newSol= new Solution(Sol);
	    		
				newSol.item.add(d.m_item);
	    		newSol.gen.add(i);
	    		
    			newSol.setWeight(newSol.getWeight()+d.m_weight*i);
    			newSol.setValue(newSol.getValue()+d.m_value*i);
    	
	    		bound = LR.solveLinear(newSol);
	    		
	    		newSol.setBound(bound);
	    		
	    		Sol.setState(2);//means this solution was branched

	    		if (bound > 0) { //feasible solution
	    			if (newSol.getNumberOfItems()==items) {
	    				newSol.setState(3);
	    				cont3++;
	    				eliminateBadSolutions(newSol.getBound()); //including partial solutions with a poor bound.
	    			}else{ //feasible partial solution
	    				newSol.setState(0); 
	    			}
				} else {//infeasible solution
					newSol.setState(-1);  
					cont1++;
				}
	    		solutions.add(newSol);	
			}
			Sol=getMaxBound(0);			
		}	
    	
    	Sol=getMaxBound(3);
    	Weight=Sol.getWeight();
    	for (int i = 0; i < Sol.gen.size(); i++) {
			taken[Sol.item.get(i)]=Sol.gen.get(i);
		}
    	taken[items]=Sol.getValue();
		return taken;
	}

	private Item nextItem(int item) {
		//Collections.sort(knapsack);
		Iterator<Item> it= knapsack.iterator();
		while (it.hasNext()) {
			Item k = it.next();
			if (k.m_item==item) {
				k = it.next();
				return k; 
			}
		}
		return knapsack.get(0);
	}

	private void eliminateBadSolutions(int bound) {
		Collections.sort(solutions);
		for (int i = 0; i < solutions.size(); i++) {
			Solution s = solutions.get(i);
			if ( s.getState()==2) {
				//s.setState(-1); 
				solutions.remove(s); 
			}else if (s.getBound() < bound) {
				//s.setState(-1); //poor solutions will be marked as state -1
				solutions.remove(s);
			}
		}
	}

	private Solution getMaxBound(int state) {
		// TODO Auto-generated method stub
		Collections.sort(solutions);
		Iterator<Solution> it= solutions.iterator();
		while (it.hasNext()) {
			Solution s = it.next();
			if (s.getState()==state) {
				return s; 
			}
		}
		
		return null;
	}
	
	
	// 0 state, 1->n alelos, n+1 weight, n+2 value, n+3 decimal	
	
}




/*
ArrayList<ArrayList<Integer>> GENS = new ArrayList<ArrayList<Integer>>();
	
   public int[] sortDensity(int items){
   	int[] Sort=new int[items];
   	return Sort;
   }
   
   public void LinnearRelaxation(int rowbase , int row, int alelo, int items, int weights[], int values[], int capacity){
   	
   	GENS.get(row).set(0, 2); // modifying state to branched
   	int Index[]=sortDensity(items);
   	int decimal = GENS.get(rowbase).set(items+3, 2); // where is the decimal alelo.

   	if( decimal!=0){
   		GENS.get(row).set(decimal, alelo); // fix the value of the alelo given 
   		int cont=0; //counter number of items included before finding optimal LR.
   		
   		while ( (GENS.get(row).get(items+1)+weights[Index[cont]])<capacity ) {
				GENS.get(row).set(cont+1,1);
		    	GENS.get(row).set(items+1, GENS.get(row).get(items+1)+weights[Index[cont]]); //accumulator of weight in the knapsack		    		
		    	GENS.get(row).set(items+2, GENS.get(row).get(items+2)+values[Index[cont]]); //accumulator of value in the knapsack					
	    		cont=cont+1;
			}
   		if (cont<items) {
				int idle=capacity-(GENS.get(row).get(items+1)+weights[Index[cont]]); // idle capacity
				int remind=idle/GENS.get(row).get(items+2);// calculate how much capacity add to saturate constrain (not always possible)
				
				GENS.get(row).set(cont,remind); // assign part of the next item to the alelo 
				GENS.get(row).set(items+3,cont); // updates the localization of decimal part
				
	    		GENS.get(row).set(items+1, GENS.get(row).get(items+1)+remind*weights[Index[cont]]); //accumulator of weight in the knapsack		    		
	    		GENS.get(row).set(items+2, GENS.get(row).get(items+2)+remind*values[Index[cont]]); //accumulator of value in the knapsack					
	    		
	    		GENS.get(row).set(0,1);  // the node is feasible, free to be branched	
	    		
			}else{
				GENS.get(row).set(0,3); // integer solution!!
			}
		}else{
			GENS.get(row).set(0,3); //state=3 terminal node discrete solution.
   	}   	
   }
   
   public int maxValueGen(int items, int estado){
   	int idmax=0;
   	int max=-1;
   	
   	for (int i = 1; i < GENS.size(); i++) { //starts in 1 b/o 0 represents the sate. 
			if (max<GENS.get(i).get(items+2) & GENS.get(i).get(0)==estado) { // select the max value of a gen which is active.
				GENS.get(idmax).set(0, -2);  //uninteresting GEN
				max=GENS.get(i).get(items+2); // assign the value of the solution
				idmax=i; // index of the maximum value GEN which can be branched.
			}
		}
   	return idmax; //if id max=0, means you are finished!
   }
   
   public void branchAndbound(int items, int capacity, int values[], int weights[], int maxiter){
   	
   	int[] taken = new int[items];// holds the solution, udated at the end.
   	
   	boolean finish=true;
   	int nvalues=2;  // branches
   	int rowbase=0;
   	int row=0; //current row
   	
   	Integer[] gen=new Integer[items+4]; // 0 state, 1->n alelos, n+1 weight, n+2 value, n+3 decimal
   	ArrayList<Integer> rowg=new  ArrayList<Integer>(Arrays.asList(gen));
	    GENS.add(rowg);
   	LinnearRelaxation(rowbase, row, 0,items, weights, values, capacity);
	    row=2;
	    
   	while (finish || maxiter==0) {
			rowbase=maxValueGen(items,1); //it calculate the max value of the gen which is feasible but not branched of terminal.
			GENS.add(rowg);
			GENS.add(rowg);
			if (rowbase>0) {
				for (int alelo = 0; alelo < nvalues; alelo++) {
					LinnearRelaxation(rowbase, row, alelo, items, weights, values, capacity);
				}
				row=row+2;
			} else {
				finish=false;
				rowbase=maxValueGen(items,3); // calculate the max gen in terminate state.
			}
			maxiter--;
		}
   	
   	// prepare the solution in the specified output format
       int value=GENS.get(rowbase).get(items+2);
   	System.out.println(value+" 1");
       for(int i=0; i < items; i++){
       	taken[i]=GENS.get(rowbase).get(i+1);
           System.out.print(taken[i]+" ");
       }
       System.out.println("");  
             
   }	 
*/
