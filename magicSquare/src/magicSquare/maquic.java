package magicSquare;

import java.lang.reflect.Array;
import java.util.Scanner;

public class maquic {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduce the size side of the magic square (ej 3,4,5)");
		Scanner in=new Scanner(System.in);
		int dim=in.nextInt();
		System.out.println("introduce the matrix to be check");
		int[][] input=new int[dim][dim];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				input[i][j]=in.nextInt();			
			}
		}
		int[] sumf=new int[dim];
		int[] sumc=new int[dim];

		for (int i = 0; i < input.length; i++) {
			//sumf[i]=0;
			//sumc[i]=0;
			for (int j = 0; j < input.length; j++) {
				sumf[i]=sumf[i]+input[i][j];
				sumc[i]=sumc[i]+input[j][i];
			}
			System.out.println("row" + sumf[i] + "Col" + sumc[i]);
		}
		//input=in.next
	}

}
