
public class SortSolutions implements Comparable<SortSolutions> {

	public long objValue;
	public Solution solution;

	public SortSolutions(long objValue, Solution solution) {
		// TODO Auto-generated constructor stub
		this.objValue=objValue;
		this.solution=solution;
	}

	// overwriting compareTo method, for sorting
	public int compareTo(SortSolutions s) {

		if (this.objValue > s.objValue) {
			return 1;
		} else if (this.objValue < s.objValue) {
			return -1;
		} else {
			return 0;
		}
	}

	// overwriting the method toString to return the object into a string
	public String toString() {
		return "Objective ("  + objValue + ") \n";
	}
		
	public Solution getSolution() {
		return solution;
	}
	
	public long getObjValue() {
		return objValue;
	}
		
}
