import java.util.*;

public class ClarkeWright {

	/*
	 * stores the different routes route1 0-2-3-4-0 is represented by {2,3} in
	 * the first row of m_routes
	 */
	ArrayList<ArrayList<Integer>> m_routes;

	private int m_nbRoutes; // number of routes

	/* holds the route number where a particular vertex is located */
	protected int[] m_routeNumberOfVertex;

	protected Solution m_solution; // solution class

	protected Instance m_instance; // instance

	protected ArrayList<Saving> m_savingList;

	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public ClarkeWright(Instance instance) throws Exception {
		// TODO Auto-generated constructor stub
		m_instance = instance;
		m_solution = new Solution(m_instance);
		m_routes = new ArrayList<ArrayList<Integer>>(
				m_instance.getNbVertices() - 1);
		m_routeNumberOfVertex = new int[m_instance.getNbVertices()];
		m_savingList = new ArrayList<Saving>();
		solve();
	}

	/*
	 * Returns the heuristic solution
	 */
	public Solution getSolution() {
		return m_solution;
	}

	/*
	 * it calculates the savings of all nodes, then put them in a list and sort
	 * them
	 */
	public void calculateSavings() throws Exception {

		for (int i = 1; i < m_instance.getNbVertices() - 1; i++) {
			for (int j = i + 1; j < m_instance.getNbVertices(); j++) {
				long value = m_instance.getDistances(0, i)
						+ m_instance.getDistances(0, j)
						- m_instance.getDistances(i, j);
				m_savingList.add(new Saving(i, j, value));
			}
		}
		// System.err.println("aqui " + m_savingList);
		// sort
		Collections.sort(m_savingList);
		// System.err.print("Savings list sorted :" );
		// System.err.println(m_savingList);
	}

	/*
	 * merge route1 and route 2, creating arc v1-v2.
	 * 
	 * @return false if the merging is not feasible
	 */
	public boolean mergeRoutes(ArrayList<Integer> route1,
			ArrayList<Integer> route2, int v1, int v2) {
		// verifies that the two vertex aren«t in the same route
		if (m_routeNumberOfVertex[v1] == m_routeNumberOfVertex[v2]) {
			return false;
		}
		/*
		 * put at the end if it is at the beginning (reverse order), nothing if
		 * it is in the middle and do nothing if it is at the end
		 */
		if (route1.get(0) == v1) {
			Collections.reverse(route1);
		}
		if (route1.get(route1.size() - 1) != v1) {
			return false;
		}
		/* route2 */
		if (route2.get(route2.size() - 1) == v2) {
			Collections.reverse(route2);
		}
		if (route2.get(0) != v2) {
			return false;
		}

		int route1Index = m_routeNumberOfVertex[v1];
		int route2Index = m_routeNumberOfVertex[v2];

		for (int i : route2) {
			m_routeNumberOfVertex[i] = route1Index; // update route number to 1
													// for all vertex of route 2
		}

		route1.addAll(route2);
		route2.clear();
		m_routes.set(route2Index, null);

		// everything was ok
		return true;
	}

	/*
	 * it creates a route for each one of the vertices
	 */
	public void initializeRoutes() {

		// System.err.println("Size of arrayList m_routes : " +
		// m_routes.size());
		for (int i = 1; i < m_instance.getNbVertices(); i++) {
			ArrayList<Integer> r = new ArrayList<Integer>();
			m_routes.add(r);
			r.add(i);
			m_routeNumberOfVertex[i] = i - 1;
		}
		m_nbRoutes = m_instance.getNbVertices() - 1;
	}

	/*
	 * clarke & wright algorithm
	 */
	public void solve() throws Exception {

		initializeRoutes();

		// for (ArrayList<Integer> r : m_routes) {
		// System.err.println(r);
		// }

		calculateSavings();

		Iterator<Saving> it = m_savingList.iterator();

		while (m_nbRoutes > 1) {

			Saving s = it.next(); // it gives the saving in decreasing value

			if (mergeRoutes(m_routes.get(m_routeNumberOfVertex[s.m_i]),
					m_routes.get(m_routeNumberOfVertex[s.m_j]), s.m_i, s.m_j)) {
				m_nbRoutes--;
			}
		}
		// copy the final route in m_solution
		int routeIndex = m_routeNumberOfVertex[1];
		int position = 1;
		for (int i : m_routes.get(routeIndex)) {
			m_solution.setVertexPosition(i, position);
			position++;
		}

		m_solution.evaluate();
		// m_solution.print(System.err);
	}
}
