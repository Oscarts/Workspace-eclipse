import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.omg.CORBA.NVList;
/**
 * @author Oscar
 *Random insertion heuristic TSP
 */
public class HFarthestInsertion {
	
	
	private Instance m_instance;  // data
	private Solution m_solution;   // solution class
	//private boolean[] IsVisited;	
	ArrayList<Integer> Visited;
	
	/**
	 * Constructor
	 */
	public HFarthestInsertion(Instance instance) {
		m_instance=instance;
		m_solution=new Solution(m_instance);
		Visited=new ArrayList<Integer>();
		//IsVisited=new boolean [m_instance.getNbVertices()];
	}

	//Returns the heuristic solution
	public Solution getSolution(){
		return m_solution;
	}
	
	/* initialized the tour*/
	public void initializeWithZeroandFarthest(int nodeIni) throws Exception{
		
		m_solution.setVertexPosition(nodeIni,0); // it sets initial node  at position 0
		Visited.add(nodeIni);
		//it finds the two farthest node from all set af vertices.
		long max=-1;
		int idxmax=0;
		for (int i = 1; i < m_instance.getNbVertices(); i++) {
			long distance=m_instance.getDistances(0, i);
			if (distance>max){
				max=distance;
				idxmax=i;
			}
		}
	
		m_solution.setVertexPosition(idxmax,1); // it sets vertex idxmax at position 1	
		m_solution.setVertexPosition(nodeIni,2);	// it sets vertex idxmax at position 2	
		Visited.add(idxmax);
		//System.out.println("second node "+ idxmax);
	}
	
	/* 
	 * Apply the heuristic to built m_solution
	 */
	public void solve() throws Exception{
		
		initializeWithZeroandFarthest(0);
		
		int iterations=m_instance.getNbVertices()-2;
		
		while ( iterations>0) {  // all vertices are visited
			
			//it finds the farthest node of the minimum  distance to some node of the tour
			long farthest=-1;
			int maxVertex=0;
			
			for (int i = 1; i < m_instance.getNbVertices(); i++) { //all nodes
				long minDistance=Long.MAX_VALUE;
				int minVertex=-1;
				for (int j = 0; j <Visited.size() ; j++) { //Visited.get(j) represent the nodes currently visited
					long distance=m_instance.getDistances(Visited.get(j), i);
				
					if (distance<minDistance && Visited.indexOf(i)==-1) {
						minDistance=distance;
						minVertex=i;
					} 
				}
				//find the farthest node
				if (farthest<minDistance && minVertex!=-1) {
					farthest=minDistance;
					maxVertex=minVertex;
				}
			}
			//it finds the minimum way to visit the farthest vertex (best position)
			long bestValue=Long.MAX_VALUE;
			int bestp=-1;
			for (int i = 1; i<=Visited.size(); i++) { // positions
				//calculates the addition cost of adding farthest vertex at position i 
				long insertionValue=m_instance.getDistances(m_solution.getSolution(i-1), maxVertex) +    // m_solution.getSolution(i-1)   gave the vertex hold in postion i-1
						m_instance.getDistances(maxVertex, m_solution.getSolution(i)) -
						m_instance.getDistances( m_solution.getSolution(i-1),m_solution.getSolution(i));
				//select the min additional cost
				if (insertionValue<bestValue ){
					bestp=i;
					bestValue=insertionValue;	
				}
			}
			
			// insert node at the best position
			m_solution.insertVertex(maxVertex,bestp,Visited.size());
			//update list of visited vertex
			Visited.add(maxVertex);			
			//stopping condition of while: go trough all nodes
			iterations--;
			
		}
		//it calculates the value of the new solution
		m_solution.evaluate();
		//m_instance.print(System.out);
	}	
				
}
