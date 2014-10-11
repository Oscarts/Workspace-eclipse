import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;


public class GRASP {
	
	Instance instance;
	Solution solution;
	Solution bestSolution;
	localSearch ls;
	ArrayList<ArrayList<Integer>> list;
	ArrayList<SortSolutions> parents;
	ArrayList<Neighborhood> movements;
	int length;
	int iterations;
	Random rand = new Random();
	HCheapestInsertion HCI;
	public long time;
	
	/**
	 * Constructor
	 * @param instance
	 * @throws Exception
	 */
	public GRASP(Instance instance, int lenghtList, long m_time) throws Exception {
		// TODO Auto-generated constructor stub
		this.instance=instance;
		solution=new Solution(instance);
		bestSolution=new Solution(instance);
		list=new ArrayList<ArrayList<Integer>>();
		parents=new ArrayList<SortSolutions>();
		this.ls=new localSearch();
		this.length=lenghtList;
		HCI=new HCheapestInsertion(instance);
		this.iterations=iterations;
		movements = new ArrayList<Neighborhood>();
		time=m_time;
	}
	
	/**
	 * @param iterations
	 * @return best solution after applying GRASP
	 * @throws Exception
	 */
	public Solution solve() throws Exception{
		
		long startT = System.currentTimeMillis(); // record start time (in ms).
		long timeSpent = 0;
		
		int poolSize;
		solution=greedyCheapest(11);
		ArrayList<SortSolutions> pool2=new ArrayList<SortSolutions>();
		ArrayList<SortSolutions> pool3=new ArrayList<SortSolutions>();
		
		while (timeSpent <= ((time * 1000) - 100)) {
			poolSize=10;
			//fill the initial pool
			int j=0; //number of solutions in pool
			int n=0; //Neighborhood
			movements.add(new NSwap(instance, "swap"));		
			while (j<poolSize) {
				HRandomInsertion hri=new HRandomInsertion(instance);
				bestSolution=hri.getSolution();
				bestSolution= ls.localSearchV(bestSolution, instance, movements);
				parents.add(new SortSolutions(bestSolution.getObjective(), bestSolution));
				j++;
			}	
			
			/*pool of promising solutions*/
			//sort parents by value
			Collections.sort(parents);
			//System.out.println(parents);
			//remove some bad solutions
			poolSize=(int)poolSize/2;
			j=0; //number of solutions in pool
			n++; //Neighborhood
			movements.add(0,new NTwoOpt(instance, "2opt"));			
			Iterator<SortSolutions> it = parents.iterator();
			while (j<poolSize) {
				SortSolutions sort =  it.next();
				bestSolution= ls.localSearchV(sort.getSolution(), instance, movements);
				pool2.add(new SortSolutions(bestSolution.getObjective(), bestSolution));
				j++;				
			}
			parents.clear();

			/*pool of elite*/
			//sort parents by value
			Collections.sort(pool2);
			//System.out.println(pool2);
			//remove some bad solutions
			poolSize=(int)poolSize/2;
			j=0; //number of solutions in pool
			n++; //Neighborhood				
			it = pool2.iterator();
			while (j<poolSize) {
				SortSolutions sort =  it.next();
				VariableNeighborhoodSolution vns=new VariableNeighborhoodSolution(instance, sort.getSolution());
				bestSolution=vns.solveVNS();
				pool3.add(new SortSolutions(bestSolution.getObjective(), bestSolution));
				j++;				
			}			
			pool2.clear();
			movements.clear();
					
			Collections.sort(pool3);
			//System.out.println(pool3);
			
			bestSolution=pool3.get(0).getSolution();
			
			if (bestSolution.getObjective()<solution.getObjective()) {
				solution=bestSolution;
				//System.err.println("BEST!!!");
			}
			pool3.clear();
			
			timeSpent = System.currentTimeMillis() - startT;
		}			
		return solution;
	}
	/**
	 * Solution of Grasp using greedy heuristic
	 */
	public Solution basicGrasp() throws Exception{
		
		long startT = System.currentTimeMillis(); // record start time (in ms).
		long timeSpent = 0;
		length=5;
		bestSolution=greedyCheapest(length);
		//HRandomInsertion ri=new HRandomInsertion(instance);
		//bestSolution=ri.getSolution();
		//bestSolution.print(System.err);	
		while (timeSpent <= ((time * 1000) - 100)) {
			solution=greedyCheapest(length);
			//HRandomInsertion rih=new HRandomInsertion(instance);
			//solution=rih.getSolution();
			//VariableNeighborhoodSolution vns=new VariableNeighborhoodSolution(instance, solution);		
			movements.add(new NSwap(instance, "swap"));	
			solution=ls.localSearchV(bestSolution, instance, movements);
			//solution.print(System.err);
			
			if (bestSolution.getObjective()>solution.getObjective()) {
				bestSolution=solution;
				//System.err.println("BEST!!!");
			}
			
			timeSpent = System.currentTimeMillis() - startT;
		}		
		return bestSolution;
	}	
	/**
	 * Solution of Grasp using greedy heuristic
	 */
	public Solution solveGreedy() throws Exception{
		
		long startT = System.currentTimeMillis(); // record start time (in ms).
		long timeSpent = 0;
		
		bestSolution=greedyCheapest(length);
		//HRandomInsertion ri=new HRandomInsertion(instance);
		//bestSolution=ri.getSolution();
		//bestSolution.print(System.err);	
		while (timeSpent <= ((time * 1000) - 100)) {
			solution=greedyCheapest(length);
			//HRandomInsertion rih=new HRandomInsertion(instance);
			//solution=rih.getSolution();
			VariableNeighborhoodSolution vns=new VariableNeighborhoodSolution(instance, solution);		
			solution=vns.solveVNS();
			//solution.print(System.err);

			if (bestSolution.getObjective()>solution.getObjective()) {
				bestSolution=solution;
				//System.err.println("BEST!!!");
			}else if (length<instance.getNbVertices()){
				length=length+2;
				//System.err.println(">>>>>length" + length);
			}
			
			timeSpent = System.currentTimeMillis() - startT;
		}		
		return bestSolution;
	}
	
	/**
	 * it Mutates the solution of a given tsp tour
	 * @param solution2
	 */
	private void mutation(Solution solution2) {
		// TODO Auto-generated method stub
		int i=1+rand.nextInt(instance.getNbVertices()-1);
		int j=1+rand.nextInt(instance.getNbVertices()-1);
		solution.swap(i, j);
	}
	/**
	 * 
	 * @param parents2
	 * @return offspring with half solution of father and half of mother
	 * @throws Exception 
	 */
	private Solution crossover(ArrayList<Solution> parents) throws Exception {
		
		int cut1=1+rand.nextInt((int)instance.getNbVertices()/2);
		int cut2=(int)instance.getNbVertices()/2+rand.nextInt((int)instance.getNbVertices()/2);
		
		Solution offspring=parents.get(1).copy();
		int i=1,j=1; //count to cover all vertices
		boolean inSolution=false;
		while (i<instance.getNbVertices()) {
			if (i>cut2 || i<cut1) {

				//check if city is already in the tour inside cuts
				inSolution=false;
				for (int k = cut1; k <= cut2; k++) {
					if (parents.get(0).getSolution(j)==offspring.getSolution(k)) {
						inSolution=true;
					}
				}
				//insert city of parent
				if(!inSolution){
					offspring.setVertexPosition(parents.get(0).getSolution(j), i);
					i++;
				}
				j++;
			}else{
				i++;
			}
		}
		//System.out.println(offspring.validate());
		offspring.evaluate();
		//offspring.print(System.out);
		return offspring;
	}

	/**
	 * Algorithm to construct a solution from scratch using cheapest insertion
	 * to determine the list of candidates.
	 * @throws Exception 
	 */
	private Solution greedyCheapest(int lengthlist) throws Exception{
		return HCI.Cheapest(lengthlist);
	}
	

//	public void stupidSolution() throws Exception {
//
//		for (int j = 0; j < instance.getNbVertices(); j++) {
//			bestSolution.setVertexPosition(j, j);
//		}
//		bestSolution.setVertexPosition(0, instance.getNbVertices());
//		bestSolution.evaluate();
//		
//	}
//	
}
