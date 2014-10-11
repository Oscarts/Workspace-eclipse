import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Method;

public class NOrOpt extends Neighborhood {
	int k;
	public NOrOpt(Instance instance, String name, int kopt) throws Exception {
		super(instance, name);
		k=kopt;
	}

	@Override
	public Solution getNeighborhood(Solution solution) throws Exception {

		Solution sol = solution.copy();

		long opt1 = solution.getObjective();
		long tempObj = 0;
		long maxObj = solution.getObjective();

		int besti = 0;
		int bestj = 0;
		//int k = 3; // length of the sequence,
		boolean improvement = false;

		for (int i = 1; i < m_instance.getNbVertices() - k + 1; i++) { 
			for (int j = 1; j < m_instance.getNbVertices() - k + 1; j++) { 

				tempObj = Long.MAX_VALUE;
				if (i != j) {
					if (j > i) {
						tempObj = opt1
								- m_instance.getDistances(sol.getSolution(i - 1),sol.getSolution(i))
								- m_instance.getDistances(sol.getSolution(i + k - 1),sol.getSolution(i + k))
								- m_instance.getDistances(sol.getSolution(j + k - 1),sol.getSolution(j + k))
								+ m_instance.getDistances(sol.getSolution(i - 1),sol.getSolution(i + k))
								+ m_instance.getDistances(sol.getSolution(i),sol.getSolution(j + k - 1))
								+ m_instance.getDistances(sol.getSolution(i + k - 1),sol.getSolution(j + k));
					} else {

						tempObj = opt1
								- m_instance.getDistances(sol.getSolution(i - 1),sol.getSolution(i))
								- m_instance.getDistances(sol.getSolution(i + k - 1),sol.getSolution(i + k))
								- m_instance.getDistances(sol.getSolution(j - 1),sol.getSolution(j))
								+ m_instance.getDistances(sol.getSolution(j - 1),sol.getSolution(i))
								+ m_instance.getDistances(sol.getSolution(i - 1),sol.getSolution(i + k))
								+ m_instance.getDistances(sol.getSolution(j),sol.getSolution(i + k - 1));

					}
				}

				if (tempObj < maxObj) {
					maxObj = tempObj;
					besti = i;
					bestj = j;
					// sol2.print(System.err); //print
					improvement = true;
				}
			}
		}
		if (improvement) {
			if (besti < bestj) {
				for (int i = besti + k; i < bestj + k; i++) {
					sol.setVertexPosition(solution.getSolution(i), i - k);
				}
			} else {
				for (int i = bestj; i < besti; i++) {
					sol.setVertexPosition(solution.getSolution(i), i + k);
				}
			}

			int h = bestj;
			for (int i = besti; i < besti + k; i++) {
				sol.setVertexPosition(solution.getSolution(i), h);
				h++;
			}

		}
		sol.evaluate();

		return sol;
	}
}
