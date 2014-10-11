import java.util.ArrayList;


public class Solution implements Comparable<Solution>{
	
	
	private int value;
	private int weight;
	private int bound;
	//public int criteria;
	
	ArrayList<Integer> gen;
	ArrayList<Integer> item;

	private int state;

	/**
	 * constructor
	 */
	public Solution(int item,int weight,int value,int alelo,int state,int bound) {
		this.item=new ArrayList<Integer>();
		this.gen=new ArrayList<Integer>();
		if (item>=0) {
			this.item.add(item);
		}
		if (alelo>=0) {
			this.gen.add(alelo);
		}		
		this.weight=weight;
		this.value=value;
		this.state=state;
		this.bound=bound;
		//this.criteria=0;	
	}
	/**
	 * Copy constructor
	 */
	public Solution( Solution newSol) {
		this.item=(ArrayList<Integer>) newSol.item.clone();
		this.gen=(ArrayList<Integer>) newSol.gen.clone();
		this.weight=newSol.weight;
		this.value=newSol.value;
		this.state=newSol.state;
		this.bound=newSol.bound;
		
	}

	/**
	 * overwriting compareTo method, for sorting 
	 */
	public int compareTo(Solution s){
//		if (criteria==0) { //sort by bound
			if (this.bound>s.bound){
				return -1;
			}else if (this.bound < s.bound) {
				return 1;
			}else {
				return 0;
			}			
//		} else {  //sort by value
//			if (this.value>s.value){
//				return -1;
//			}else if (this.value < s.value) {
//				return 1;
//			}else {
//				return 0;
//			}
//		}
	}
	/**
	 *  overwriting the method toString to return the object into a string, 
	 *  format used used in print statement.
	 */
	public String toString(){
		return "Solution ("+ "v:" +value  + ", w:" +weight  + ", b:" + bound + ")  state:" + state + "\n";
	}
	
	
	public void setState(int state) {
		this.state = state;
	}
	public void setBound(int bound) {
		this.bound = bound;
	}
 
	public int getNumberOfItems() {
		// TODO Auto-generated method stub
		return item.size();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ArrayList<Integer> getGen() {
		return gen;
	}

	public void setGen(ArrayList<Integer> gen) {
		this.gen = gen;
	}

	public ArrayList<Integer> getItem() {
		return item;
	}

	public void setItem(ArrayList<Integer> item) {
		this.item = item;
	}

	public int getBound() {
		return bound;
	}

	public int getState() {
		return state;
	}


}
