import java.util.*;

import org.omg.CORBA.NVList;

/**
 * @author Oscar Random insertion heuristic TSP
 */
public class HCheapestInsertion extends HInsertion {

	/**
	 * Constructor
	 */
	public HCheapestInsertion(Instance instance) throws Exception {
		super(instance); // first i have to call constructor of father.
		// add customized parameters...
		//solve();
	}
	/**
	 * 
	 * @see HInsertion#solve()
	 */
	public Solution Cheapest( int length) throws Exception {
		
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		Random rand = new Random();
		initializeWithZeroandFarthest(); //required to reset isVisited
		
		while (ncv <= m_instance.getNbVertices()) { // all vertices are visited

			Long minDistance = Long.MAX_VALUE;
			int position = -1;
			int vertex = -1;

			for (int j = 0; j < m_instance.getNbVertices(); j++) { // vertices
				for (int i = 1; i < ncv; i++) { // positions
					// m_solution.getSolution(i-1) gave the vertex hold in postion i-1
					Long insertionValue = m_instance.getDistances(m_solution.getSolution(i - 1), j)
							+m_instance.getDistances(j,m_solution.getSolution(i))
							- m_instance.getDistances(m_solution.getSolution(i - 1),
							m_solution.getSolution(i));
					
					if (minDistance > insertionValue && IsVisited[j] == false) {

						minDistance = insertionValue;
						ArrayList<Integer> neighboor=new ArrayList<Integer>(2);
						neighboor.add(j); //vertex
						neighboor.add(i); //position
						list.add(neighboor);
						
						if (list.size()>length) {
							list.remove(0);
						}
					}
				}
			}
			
			int randVertex=rand.nextInt(list.size());
			vertex = list.get(randVertex).get(0);
			position=list.get(randVertex).get(1);
			m_solution.insertVertex(vertex, position, ncv);
			list.clear();
			ncv++;
			IsVisited[vertex] = true;
		}
		m_solution.evaluate();

		return m_solution;
	}

	/*
	 * Apply the heuristic to built m_solution
	 */
	public void solve() throws Exception {

		initializeWithZeroandFarthest();

		while (ncv <= m_instance.getNbVertices()) { // all vertices are visited

			Long minDistance = Long.MAX_VALUE;
			int position = -1;
			int vertex = -1;

			for (int j = 0; j < m_instance.getNbVertices(); j++) { // vertices
				for (int i = 1; i < ncv; i++) { // positions
					// m_solution.getSolution(i-1) gave the vertex hold in postion i-1
					Long insertionValue = m_instance.getDistances(m_solution.getSolution(i - 1), j)
							+m_instance.getDistances(j,m_solution.getSolution(i))
							- m_instance.getDistances(m_solution.getSolution(i - 1),
							m_solution.getSolution(i));
					
					if (minDistance > insertionValue && IsVisited[j] == false) {
						minDistance = insertionValue;
						position = i;
						vertex = j;
					}
				}
			}
			m_solution.insertVertex(vertex, position, ncv);
			ncv++;
			IsVisited[vertex] = true;
		}
		// it calculates the value of the new solution
		m_solution.evaluate();
		//m_instance.print(System.out);
	}

}
