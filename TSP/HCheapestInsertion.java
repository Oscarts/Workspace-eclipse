import java.util.*;

import org.omg.CORBA.NVList;
/**
 * @author Oscar
 *Random insertion heuristic TSP
 */
public class HCheapestInsertion extends HInsertion{
	
	/**
	 * Constructor
	 */
	public HCheapestInsertion(Instance instance) throws Exception {
		super(instance); //first i have to call constructor of father.  
		//add customized parameters...
	}

	/* 
	 * Apply the heuristic to built m_solution
	 */
	public void solve() throws Exception{
		
		initializeWithZeroandFarthest();
		
		
		while ( ncv <= m_instance.getNbVertices()	) {  // all vertices are visited
			
			Long minDistance=Long.MAX_VALUE;
			int position=-1;
			int vertex=-1;
			
			for (int j = 0; j < m_instance.getNbVertices(); j++) {  //vertices
				for (int i = 1; i < ncv; i++) { //positions
					
					Long insertionValue=m_instance.getDistances(m_solution.getSolution(i-1), j) +    // m_solution.getSolution(i-1)   gave the vertex hold in postion i-1
							m_instance.getDistances(j, m_solution.getSolution(i)) -
							m_instance.getDistances( m_solution.getSolution(i-1),m_solution.getSolution(i));
					
					if (minDistance>insertionValue && IsVisited[j]==false) {
						minDistance=insertionValue;
						position=i;
						vertex=j;
						//System.out.println("PO" + position + "VER" + vertex);
					}
				}
			}
			// insert node at the best position
			//System.out.println("Insert PO" + position + "VER" + vertex);
			m_solution.insertVertex(vertex, position, ncv);
			ncv++;
			IsVisited[vertex]=true;
			//update list of visited vertex
			//Visited.add(vertex);			
			//stopping condition of while: go trough all nodes	
		}
		//it calculates the value of the new solution
		m_solution.evaluate();
		//m_instance.print(System.out);
	}	
}
