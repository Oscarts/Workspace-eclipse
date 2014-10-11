import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class VariableNeighborhoodSolution {

	ArrayList<Neighborhood> movements; //storage of neighbourhoods
	Instance instance;
	Solution solution;
	localSearch ls;
	int n;
	public VariableNeighborhoodSolution(Instance instance,Solution initialSolution) throws Exception {
		// TODO Auto-generated constructor stub
		this.instance = instance;
		solution = initialSolution;
		ls = new localSearch();
		movements = new ArrayList<Neighborhood>();
		Random r=new Random();
		int rnd=r.nextInt(3);
		if (rnd==0) {
			movements.add(new NSwap(instance, "swap"));
			movements.add(new NTwoOpt(instance, "2opt"));
			movements.add(new NOrOpt(instance, "or-opt",2));
			movements.add(new NOrOpt(instance, "or-opt",3));
		} else if (rnd==1) {
			movements.add(new NOrOpt(instance, "or-opt",2));
			movements.add(new NSwap(instance, "swap"));
			movements.add(new NTwoOpt(instance, "2opt"));
			movements.add(new NOrOpt(instance, "or-opt",3));	
		} else {
			movements.add(new NOrOpt(instance, "or-opt",3));
			movements.add(new NTwoOpt(instance, "2opt"));
			movements.add(new NOrOpt(instance, "or-opt",2));
			movements.add(new NSwap(instance, "swap"));
		}
		
	}

	public Solution solveVNS() throws Exception {

		boolean improvement = true;
		long obj1 = solution.getObjective();
		Solution improvedSolution = solution.copy();
		int index = 0;
		int k=3;
		while (improvement) {

			if (index < movements.size()) { 		//It goes through all neighbourhoods storage at movements
				//if using that neighbourhood achieve an improvement, then it applies local search
				if (obj1 > movements.get(index).getNeighborhood(improvedSolution).getObjective()) {
					improvedSolution = ls.solvelocalSearch(improvedSolution,movements.get(index));
					obj1 = improvedSolution.getObjective();		
					index = 0;				
				} else {
					index++; // to try with next neighbourhood at movements
				}
				
			} else {
					improvement = false;  //no more improvements
			}
		}
		return improvedSolution;
	}
	
	
	public void addNeighborhood( Neighborhood neighborhood){
		movements.add(neighborhood);
	}
}
