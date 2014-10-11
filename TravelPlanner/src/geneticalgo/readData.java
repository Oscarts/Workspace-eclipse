package geneticalgo;
import java.io.BufferedReader;  
import java.io.FileReader;  
  
/** 
 * Creates a 2D matrix  
 */  
public class readData {
	
    private static BufferedReader in = null;  
    private static int rows = 0;  
    private static String[] names;
    private static int columns = 0;  
    private static double [][] matrix = null;  
	
    public readData() {
		// TODO Auto-generated constructor stub
	} 
  
    public static void main(String []args) throws Exception {  
        try { 
        	
            String filepath = args[0];  
            int lineNum = 0;  
            int row=0;  
            in = new BufferedReader(new FileReader(filepath));  
            
            String line = null;  
            while((line=in.readLine()) !=null ) {  
            	
            	lineNum++;
                if(lineNum==1){
	                String [] name = line.split("\t");
	                int dim=name.length-1;
	                names=new String[dim];
	                for (int i = 1; i < name.length; i++) {
						names[i-1]=name[i];
					} 
	                //matrix was born
	                matrix=new double[dim][dim];
	                
                }else{

                	String [] tokens = line.split("\t");  
                    for (int j=1; j<tokens.length; j++) {  
                    	matrix[row][j-1] = Double.parseDouble(tokens[j]);  
                    }  
                    row++;  
                	
                }
            }
                
//            Just print matrix
            for (int i = 0; i < 5; i++) {
            	for (int j = 0; j < 5; j++) {
    				System.out.print(matrix[i][j]+ "\t");	
				}
            	System.out.println();
			}
            
        } catch (Exception ex) {  
            System.out.println("The code throws an exception");  
            System.out.println(ex.getMessage());  
        } finally {  
            if (in!=null) in.close();  
        }  
    }  
} 

