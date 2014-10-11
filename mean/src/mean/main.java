package mean;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		
		ArrayList<String> tmp = new ArrayList<String>();
		System.out.println("write a number or f to finish");
		tmp.add(new String(in.next()));
		int j=0;
		
		while (!tmp.get(j).equalsIgnoreCase("f")) {
			j=j+1;
			System.out.println("write a number or f to finish");
		    tmp.add(new String(in.next()));
		}
		// This creates a new array and copies the element of 'tmp' to it.
		String[] array = tmp.toArray(new String[tmp.size()]);
		double sum=0;
		for (int i = 0; i < array.length-1; i++) {
			sum += Double.parseDouble(array[i]);				
		}
		System.out.println("mean" + sum/(array.length-1));

	}

}
