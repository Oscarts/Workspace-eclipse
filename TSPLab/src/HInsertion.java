import java.util.*;

import org.omg.CORBA.NVList;

/**
 * @author Oscar Random insertion heuristic TSP
 */
public abstract class HInsertion {

	protected Instance m_instance; // data
	protected Solution m_solution; // solution class
	protected int ncv = 0; // number of connected vertices in the tour
	protected boolean[] IsVisited;
	protected ArrayList<Integer> Visited;
	protected int idxmax=0;

	/**
	 * Constructor
	 */
	public HInsertion(Instance instance) throws Exception {
		m_instance = instance;
		m_solution = new Solution(m_instance);
		IsVisited = new boolean[m_instance.getNbVertices()];
		Visited = new ArrayList<Integer>();
		
	}

	// Returns the heuristic solution
	public Solution getSolution() {
		return m_solution;
	}
	/**
	 * initialize with zero, then farthest (so that cheapest insertion can work)
	 * @throws Exception
	 */
	public void initializeWithZeroandFarthest() throws Exception {

		for (int i = 0; i < IsVisited.length; i++) {
			IsVisited[i]=false;
		}
		
		m_solution.setVertexPosition(0, 0);
		IsVisited[0] = true;
		Visited.add(0);
		long max = -1;
		idxmax = 0;

		for (int i = 1; i < m_instance.getNbVertices(); i++) {
			long distance = m_instance.getDistances(0, i);
			if (distance > max) {
				max = distance;
				idxmax = i;
			}
		}

		m_solution.setVertexPosition(idxmax, 1);
		m_solution.setVertexPosition(0, 2);
		IsVisited[idxmax] = true;
		Visited.add(idxmax);
		Visited.add(0);
		ncv = 3;
		
	}

	/*
	 * Apply the heuristic to built m_solution, abstract means that will be
	 * overwrite in the sons methods.
	 */
	public abstract void solve() throws Exception;

}