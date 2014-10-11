import java.util.Scanner;


public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Factorial: write an integer number...");
		Scanner in=new Scanner(System.in);
		int number=in.nextInt();
		double factorial=1;
		
		for (int i = 0; i < number; i++) {
			factorial=factorial*(i+1);
		}
		System.out.println(factorial);
	}

}
