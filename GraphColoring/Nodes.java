import java.util.ArrayList;


public class Nodes implements Comparable<Nodes> {
	
	
	public int degree;
	public int node;
	ArrayList<Integer> conections;

	public Nodes(int degree, int node,ArrayList<Integer> conections) {
		// TODO Auto-generated constructor stub
		this.degree=degree;
		this.node=node;
		this.conections=conections;
	}


	//overwriting compareTo method, for sorting 
	public int compareTo(Nodes n){
	
		if (this.degree>n.degree){
			return -1;
		}else if (this.degree< n.degree) {
			return 1;
		}else {
			return 0;
		}
	}
	public void increaseDegree(){
		degree++;
	}
	//  overwriting the method toString to return the object into a string
	public String toString(){
		return "Node("+ node+ "," +degree+ "," + conections + ") \n";
	}
}

