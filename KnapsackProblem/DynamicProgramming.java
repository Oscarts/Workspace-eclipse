
public class DynamicProgramming {
	
	int items;
	int capacity;
	int[] values;
	int[] weights;
	
	public DynamicProgramming(int m_items, int m_capacity, int m_values[], int m_weights[]) {
		items=m_items;
		capacity=m_capacity;
		values= m_values;
		weights=m_weights;
		
		// TODO Auto-generated constructor stub
	}
	
    // solving knapsack to optimality with dynamic programming, < 5000 variables aprox
    public void solve(){
    	
        int[] taken = new int[items];
        int[][] DP= new int[capacity+1][items+1];
      
        for (int j = 1; j <= items; j++) {  //items- Columns
        	for (int i = 0; i <= capacity; i++) {   //capacity - rows                		
        		//System.out.println("ANTES:" + "i :"+ i +" w[j-1]:"+weights[j-1]);
        		if (i>=weights[j-1]){	
    				DP[i][j]=Math.max(values[j-1]+DP[i-weights[j-1]][j-1], DP[i][j-1]);
    				//System.out.println("1 "+DP[i][j]);
        		}else{
					DP[i][j]=DP[i][j-1];
					//System.out.println("3 "+DP[i][j]);
        		}	
			}
		}	
        
        //print table
        /*
        for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < DP[0].length; j++) {
				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}
        */
        
        // tracking the solution
        int temp=DP[capacity][items];
       // System.out.println(temp);
    	for (int j = items; j>0 ; j--) {  //items
    	    for (int i = 0; i <=capacity; i++) {   //capacity
    			//System.out.println(i + "," + j);
    	    	if (DP[i][j]==temp){
    	    		if (DP[i][j]==DP[i][j-1]){
    	    			taken[j-1]=0;
    	    		}else{
    	    			taken[j-1]=1;
    	    			temp=DP[i][j]-values[j-1];
    	    		}
    	    		break;
    	    	}
    	    	//System.out.println(taken[j-1]);
    	    }
        }
    	
    	int value=DP[capacity][items];
    	
    	// prepare the solution in the specified output format
        System.out.println(value+" 1");
        for(int i=0; i < items; i++){
            System.out.print(taken[i]+" ");
        }
        System.out.println("");      
              
    }

}
