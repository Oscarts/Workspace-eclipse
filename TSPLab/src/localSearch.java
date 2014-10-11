import java.util.ArrayList;
import java.util.Random;

public class localSearch {

	Neighborhood movement;
	ArrayList<Neighborhood> movements;

	public localSearch()throws Exception {
		// TODO Auto-generated constructor stub
		movements=new ArrayList<Neighborhood>();
	}
	/**
	 * @param solution
	 * @param instance
	 * @return solution after local search using different movements
	 * @throws Exception
	 */
	 
	public Solution localSearchV(Solution solution, Instance instance, ArrayList<Neighborhood> movements ) throws Exception {
		this.movements = movements;
		Solution S = solution.copy();
		long Sobj = S.getObjective();

		Solution S2 = solution.copy();
		long Sobj2 = S.getObjective();

		long diff = Long.MAX_VALUE;
		int neighboor=0;
		while (neighboor < movements.size()) {

			S2 = movements.get(neighboor).getNeighborhood(S);
			Sobj2 = S2.getObjective();

			diff = Sobj - Sobj2;
			if (diff > 0) {
				S = S2.copy();
				Sobj = S.getObjective();
			}else{
				neighboor++;
			}
		}

		return S;
	}
	
	public Solution solvelocalSearch(Solution solution, Neighborhood movement) throws Exception {

		this.movement = movement;
		
		Solution S = solution.copy();
		long Sobj = S.getObjective();

		Solution S2 = solution.copy();
		long Sobj2 = S.getObjective();

		long diff = Long.MAX_VALUE;

		while (diff > 0) {

			S2 = movement.getNeighborhood(S);

			Sobj2 = S2.getObjective();
			diff = Sobj - Sobj2;

			if (diff > 0) {
				S = S2.copy();
				Sobj = S.getObjective();
			}
		}

		return S;
	}
}
