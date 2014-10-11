import java.util.Scanner;


public class Fibonacci {
	
	int n;

	public void fibonnacci(int n){
		this.n=n;
		int[] F = new int[n];
		F[0]=1;
		F[1]=1;
		for (int i = 2; i < F.length; i++) {
			F[i]=F[i-1]+F[i-2];
			System.out.println(F[i]);
		}
	}
	public int fibor(int m){
		int n=m;
		if (n==1||n==0){
			return 1;
		}else {
			return fibor(n-1)+fibor(n-2);
		}
				
	}
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Introduce how many numbers of the fibonacci serie you want to see:");
		int n=in.nextInt();
		Fibonacci F=new Fibonacci();
		//F.fibonnacci(n);
		for (int i = 0; i < n; i++) {
			System.out.println(F.fibor(i));
		}
	}
}
