import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LinearRelaxation {

	protected ArrayList<Item> knapsack;
	private int items;
	private int capacity;
	public int  weight;
	private int  value;
	
	public LinearRelaxation(ArrayList<Item> data,int items, int capacity) {
		this.knapsack=new ArrayList<Item>();
		this.knapsack=data;
		this.items=items;
		this.capacity=capacity;
		weight=0;
		value=0;
	}
	
	public int[] solveDiscrete(){
        
    	int[] taken = new int[items+1];
    	
    	Collections.sort(knapsack);
		//System.out.println(data);  //Print all list
    	Iterator<Item> it=knapsack.iterator();
    	Item d=it.next();
    	while (weight+ d.m_weight<=capacity) {
    		
			weight=weight+d.m_weight;
			value=value+d.m_value;
			taken[d.m_item]=1;
			d=it.next();
		}
    	
    	taken[items]=value;
    	/*
      	// prepare the solution in the specified output format
    	System.out.println(value+" 0");
        for(int i=0; i < items; i++){
            System.out.print(taken[i]+" ");
        }
        System.out.println("");
        */
    	return taken;

	}
	
	public int solveLinear(Solution sol){
        
		
		Collections.sort(knapsack);
        //System.out.println(data);  //Print all list
        
    	double  weight=sol.getWeight();
    	double  value=sol.getValue();
    	Iterator<Item> it=knapsack.iterator();
    	Item d=it.next();
    	int cont=0;
    	
    	if (weight>capacity){
    		return -1;
    	} else if (weight>capacity){
    		return (int) value;	
    	}else{
 
    		while (((weight+ d.m_weight<=capacity) || cont!=sol.getNumberOfItems()) && it.hasNext()) {
				int index=sol.item.indexOf(d.m_item);
				if (index==-1 ) {	
		    		weight=weight+d.m_weight;
	    			value=value+d.m_value;
				} else {
	    			cont=cont+1; 
				} 
				d=it.next();	
			}
        	if (weight<capacity && items!=sol.getNumberOfItems()){
        		double proportion=Math.min(1, ((capacity-weight)/d.m_weight));
            	value=(value+d.m_value*proportion);
            	weight=(weight+d.m_weight*proportion);	
    		}
        	return (int) value;
    	} 
	}


	
	
//	public void calculateAndSortdensity() throws Exception{
//		for (int i= 1; i <m_instance.getNbVertices()-1; i++) {
//			for (int j = i+1; j < m_instance.getNbVertices(); j++) {		
//				long value=m_instance.getDistances(0, i)+m_instance.getDistances(0, j)-m_instance.getDistances(i, j);
//				m_savingList.add(new Saving(i, j,value));				
//			}
//		}
//		//System.err.println("aqui " + m_savingList);
//		//sort
//		Collections.sort(m_savingList);
//		//System.err.print("Savings list sorted :" );
//		//System.err.println(m_savingList);
//	}
}
