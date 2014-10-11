public class NSwap extends Neighborhood {

	public NSwap(Instance instance, String name) throws Exception {
		super(instance, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Solution getNeighborhood(Solution solution) throws Exception {
		Solution sol = solution.copy();

		long opt1 = solution.getObjective();
		long tempObj = 0;
		long maxObj = solution.getObjective();

		int besti = 0;
		int bestj = 0;
		int vertexj = 0;
		boolean improvement = false;

		for (int i = 1; i < m_instance.getNbVertices() - 1; i++) { // position 1
			for (int j = i + 1; j < m_instance.getNbVertices(); j++) { // position
																		// 2

				if (j == i + 1) {

					tempObj = opt1
							- m_instance.getDistances(sol.getSolution(i - 1),
									sol.getSolution(i))
							- m_instance.getDistances(sol.getSolution(j),
									sol.getSolution(j + 1))
							+ m_instance.getDistances(sol.getSolution(i),
									sol.getSolution(j + 1))
							+ m_instance.getDistances(sol.getSolution(i - 1),
									sol.getSolution(j));

				} else {
					tempObj = opt1
							- m_instance.getDistances(sol.getSolution(i - 1),
									sol.getSolution(i))
							- m_instance.getDistances(sol.getSolution(i),
									sol.getSolution(i + 1))
							- m_instance.getDistances(sol.getSolution(j - 1),
									sol.getSolution(j))
							- m_instance.getDistances(sol.getSolution(j),
									sol.getSolution(j + 1))
							+ m_instance.getDistances(sol.getSolution(i),
									sol.getSolution(j + 1))
							+ m_instance.getDistances(sol.getSolution(i),
									sol.getSolution(j - 1))
							+ m_instance.getDistances(sol.getSolution(i - 1),
									sol.getSolution(j))
							+ m_instance.getDistances(sol.getSolution(i + 1),
									sol.getSolution(j));
				}

				if (tempObj < maxObj) {
					// System.err.println("improvement!" + " i " + i + " j " +
					// j+" tempObj: "+ tempObj);
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
			vertexj = solution.getSolution(bestj);
			sol.setVertexPosition(solution.getSolution(besti), bestj);
			sol.setVertexPosition(vertexj, besti);
			sol.evaluate();
		}

		return sol;
	}

}
