public class NTwoOpt extends Neighborhood {

	public NTwoOpt(Instance instance, String name) throws Exception {
		super(instance, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Solution getNeighborhood(Solution solution) throws Exception {
		// TODO Auto-generated method stub
		Solution sol = solution.copy();

		long opt1 = solution.getObjective();
		long tempObj = 0;
		long maxObj = solution.getObjective();

		int besti = 0;
		int bestj = 0;

		boolean improvement = false;

		for (int i = 1; i < m_instance.getNbVertices() - 1; i++) { // vertex
			for (int j = i + 1; j < m_instance.getNbVertices(); j++) { // vertex

				tempObj = opt1
						- m_instance.getDistances(sol.getSolution(i - 1),sol.getSolution(i))
						- m_instance.getDistances(sol.getSolution(j),sol.getSolution(j + 1))
						+ m_instance.getDistances(sol.getSolution(i),sol.getSolution(j + 1))
						+ m_instance.getDistances(sol.getSolution(i - 1),sol.getSolution(j));

				if (tempObj < maxObj) {
					// record values
					maxObj = tempObj;
					besti = i;
					bestj = j;
					// sol2.print(System.err); //print
					improvement = true;

				} else {
					// System.err.print("   don«t swap!");
				}
			}
		}
		if (improvement) {
			// definitive swap
			// System.out.println(besti + " " + bestj);
			sol.reverse(besti, bestj);
			sol.evaluate();
		}
		// System.err.println("finish 2opt");
		// sol.print(System.err);
		return sol;

	}
}
