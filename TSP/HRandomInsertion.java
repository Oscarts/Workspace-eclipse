import java.util.*;

import org.omg.CORBA.NVList;
/**
 * @author Oscar
 *Random insertion heuristic TSP
 */
public class HRandomInsertion extends HInsertion{
	
	/**
	 * Constructor
	 */
	public HRandomInsertion(Instance instance) throws Exception {
		super(instance); //first i have to call constructor of father.  
		//add customized parameters...
	}

	/* 
	 * Apply the heuristic to built m_solution
	 */
	public void solve() throws Exception{
		
		initializeWithZeroandFarthest();
						
		Random rndGenerator=new Random(0);
		int iterations=m_instance.getNbVertices()-2;
		
		while ( iterations>0) {  // all vertices are visited
			//find randomly the next vertex to include in the tour
			int rndVertex=0;			
			while(IsVisited[rndVertex]){ //find a random vertex to visit
				rndVertex=rndGenerator.nextInt(m_instance.getNbVertices());
			}
			
			//find the best position
			int bestp=-1;
			Long bestValue=Long.MAX_VALUE;
			for (int i = 1; i < ncv; i++) { // positions
				 
				Long insertionValue=m_instance.getDistances(m_solution.getSolution(i-1), rndVertex) +    // m_solution.getSolution(i-1)   gave the vertex hold in postion i-1
						m_instance.getDistances(rndVertex, m_solution.getSolution(i)) -
						m_instance.getDistances( m_solution.getSolution(i-1),m_solution.getSolution(i));
						
				if (insertionValue<bestValue){
					bestp=i;
					bestValue=insertionValue;					
				}
			}

			// insert at the best position
			m_solution.insertVertex(rndVertex,bestp,ncv);
			IsVisited[rndVertex]=true;
			ncv++;
			iterations--;
		}
		m_solution.evaluate();
	}	
}
