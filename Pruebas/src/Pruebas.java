
import java.util.ArrayList;
import java.util.Arrays;


public class Pruebas {

	public static void main(String[] args) {
		//creating an arraylist
		 ArrayList<Integer> marks=new ArrayList<Integer>(); 
		 
		 
		 System.out.println("Size:"+marks.size());
		 marks.add(null);
		 
		 System.out.println("Size:"+marks.size());
		 
	  /* int m,size; 
	     size=(int)(Math.random()*100+1); 
		 System.out.println("Size:"+size); 
		 
		
		 for(int i=0;i<size;i++){ 
			 m=(int)(Math.random()*50); 
			 marks.add(m); 
		 } 
		 for(int i=0;i<marks.size();i++) {
			 System.out.print (marks.get(i)+" "); 
		 }
		 System.out.println();
		  int ROW_COUNT = 5;
		  int COL_COUNT = 10;

		  // creating an arraylist 2D
	      ArrayList<ArrayList<Integer>> grades = new ArrayList<ArrayList<Integer>>();

	      //filling an arraylist
	      for (int i = 0; i < ROW_COUNT; i++) {
	         ArrayList<Integer> row = new ArrayList<Integer>();
	         for (int j = 0; j < COL_COUNT; j++) {
	            row.add(100 - j - i);
	         }
	         grades.add(row);
	      }
	      
	      // how to access and edit a value for row 0, set value 1 at index 0. 
	      grades.get(0).set(0, 1);
	      
	      //adding an array to an arraylist
	      Integer[] val=new Integer[10];
	      for (int i = 0; i < val.length; i++) {
			val[i]=i;
	      }
	      ArrayList<Integer> row2=new  ArrayList<Integer>(Arrays.asList(val));
	      grades.add(row2);
	      
	      //printing arraylist
	      for (int i = 0; i < ROW_COUNT+1; i++) {
	         for (int j = 0; j < COL_COUNT; j++) {
	            System.out.print(grades.get(i).get(j)+", ");
	         }
	         System.out.println();
	      }
	   		 */

	}
	public void sorting(){
        //Array de String
        String[] nombres = {"Pepe", "Juan", "Alex",
            "Julian", "Francisco", "Luis"};
 
        //Ordena el array
        Arrays.sort(nombres);
 
        //Mostramos el array ya ordenado
        for (String k : nombres) {
            System.out.print(k + ", ");
        }
	}

}
