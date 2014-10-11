import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class ColoringGraphAlgorithm {
	
	private static ArrayList<Nodes> edges;
	private int[] nodes;
	private int nnodes;
	
	public ColoringGraphAlgorithm(ArrayList<Nodes> edges, int nnodes) {
		this.edges=edges;
		this.nodes=new int[nnodes+1];
		this.nnodes=nnodes;
	}
	
	public int[] solve(){
		
		Collections.sort(edges);
		Iterator<Nodes> it= edges.iterator();
		
		boolean infeasible=true;
		int idxNode=0;
		int color=0;
		
		while (it.hasNext()) {
			Nodes vertex = it.next();
			idxNode=vertex.node;
			color=0;
			while (infeasible) {
				color++;
				infeasible=evaluatefeasibility(idxNode,color);
			}
			nodes[idxNode]=color;
			infeasible=true;
			
		}
		nodes[nnodes]=maxColor(nodes);
		return nodes;
	}

	private int maxColor(int[] nodes) {
		// TODO Auto-generated method stub
		int max=0;
		for (int i = 0; i < nodes.length; i++) {
			if (max<nodes[i]){
				max=nodes[i];
			}
		}
		return max; 
	}

	private boolean evaluatefeasibility(int idxNode, int color) {
		// TODO Auto-generated method stub
		boolean notfind=true;
		int idx=-1;
		while(notfind){
			idx++;
			if(edges.get(idx).node==idxNode){
				notfind=false;
			}
		}
		ArrayList<Integer> row=edges.get(idx).conections;
		Iterator<Integer> n= row.iterator();
		while (n.hasNext()) {
			Integer node = n.next();
			//System.out.println(node);
			if (nodes[node]==color) {
				return true;
			}	
		}
		return false;
	}

}
