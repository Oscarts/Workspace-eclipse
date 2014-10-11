
/**
 * @author oscar
 * 
 */
public class Saving implements Comparable<Saving> {

	public int m_i;
	public int m_j;
	public long m_value;

	/**
	 * constructor
	 */
	public Saving(int i, int j, long v) {
		m_i = i;
		m_j = j;
		m_value = v;
	}

	// overwriting compareTo method, for sorting
	public int compareTo(Saving s) {

		if (this.m_value > s.m_value) {
			return -1;
		} else if (this.m_value < s.m_value) {
			return 1;
		} else {
			return 0;
		}
	}

	// overwriting the method toString to return the object into a string
	public String toString() {
		return "density (" + m_i + "," + m_j + ") =" + m_value + "\n";
	}

}
