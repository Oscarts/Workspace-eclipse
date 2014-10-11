
abstract public class Neighborhood {

	/** Link to the problem data */
	protected Instance m_instance;
	protected String name;

	/**
	 * Constructor
	 */
	public Neighborhood(Instance instance, String name) throws Exception {
		m_instance = instance;
		this.name = name;
	}

	/** Apply the neighborhood to get a neighbor */
	public abstract Solution getNeighborhood(Solution sol) throws Exception;

	/**
	 * 
	 * @return name of the movement used
	 */
	public String getName() {
		return name;
	}

}