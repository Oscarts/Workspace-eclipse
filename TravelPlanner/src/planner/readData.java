package planner;
import java.io.BufferedReader;  
import java.io.FileReader;  
  
/** 
 * Creates a 2D matrix  
 */  
public class readData {
	
    private static BufferedReader in = null;  
    private static int rows = 0;  
    public static String[] names;
    private static int columns = 0;  
    private double [][] matrix = null;  
	
	
	/**
	 * Constructor
	 * @param filename
	 * @throws Exception
	 */
    public readData(String filename) throws Exception {
		// TODO Auto-generated constructor stub
    	dataMatrix(filename);
	} 
  
    public int getNumberCities() {
		return matrix.length;
	}
    
    /**
     * @return distance matrix
     */
    public double[][] getMatrix() {
		return matrix;
	}
    /**
     * @param from
     * @param to
     * @return distance between to points
     */
    public double getDistances(int from, int to){
    	return matrix[from][to];
    }
    /**
     * load data into a matrix
     * @param file
     * @throws Exception
     */
    public void dataMatrix(String file) throws Exception {  
        try { 
        	
            String filepath = file;  
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
//            for (int i = 0; i < 5; i++) {
//            	for (int j = 0; j < 5; j++) {
//    				System.out.print(matrix[i][j]+ "\t");	
//				}
//            	System.out.println();
//			}
            
        } catch (Exception ex) {  
            System.out.println("The code throws an exception");  
            System.out.println(ex.getMessage());  
        } finally {  
            if (in!=null) in.close();  
        }  
    }  
} 

