import java.util.Arrays;

//funciona pero quizas es ineficiente.
public class Densidades {

	public Densidades() {
		// TODO Auto-generated constructor stub
	}

   public void density(int items, int capacity, double density[],int weights[], int values[]){

        // it takes items according to density order until the knapsack is full
        int value = 0;
        int weight = 0;
        int[] taken = new int[items];
        double[] densitySort=density.clone();
      
		Arrays.sort(densitySort);
		boolean empty=true;
		int cont=items-1;
		
	    while (empty && cont!=0){	
	        for (int i = 0; i < taken.length; i++) {
	        	if (densitySort[cont]==density[i] ){
	        		if (weight+weights[i]<=capacity && taken[i]!=1 ){
        		        taken[i] = 1;
            		    value += values[i];
           			 	weight += weights[i];
           			 	//System.out.println("bag" + value + "-" + weight);
           			 	break;
	            	} else {
	            		empty=false;
        	    	}
	        	}
	        }
        	cont=cont-1;	
        }
	    
        // prepare the solution in the specified output format
        System.out.println(value+" 0");
        for(int i=0; i < items; i++){
            System.out.print(taken[i]+" ");
        }
        System.out.println("");       	
    }
    	
}
