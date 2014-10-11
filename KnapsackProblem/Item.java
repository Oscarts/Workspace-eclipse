import java.util.Collection;

/**
 * @author oscar
 *
 */
public class Item implements Comparable<Item> {

	public int m_weight;
	public int m_value;
	public double m_density;
	public int m_item;
	
	/**
	 * constructor
	 */
	public Item(int item,int weight, int value, double density) {
		m_item=item;
		m_weight=weight;
		m_value=value;
		m_density=density;
	}
	//overwriting compareTo method, for sorting 
	public int compareTo(Item I){
	
		if (this.m_density>I.m_density){
			return -1;
		}else if (this.m_density < I.m_density) {
			return 1;
		}else {
			return 0;
		}
	}

	//  overwriting the method toString to return the object into a string
	public String toString(){
		return "Knapsack("+ m_item  + "," +m_value  + "," + m_weight + ") =" + m_density + "\n";
	}
}














