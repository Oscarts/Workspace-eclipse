import java.util.Scanner;



public class Exercise3_1 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    Integer n, fib;

    // Read the number
    System.out.println("Print a number");
    n= Integer.valueOf(in.nextLine());
    
    
    // Compute the Fibonacci number
    fib = fibonacci(n);
    
    // Return the Fibonacci number
    if (fib != null) {
      System.out.println("The fibonacci number is " + fib);
    }
  }


  private static Integer fibonacci(Integer n) {
    if (n < 0) {
      System.out.println("Please enter a positive integer");
      return null;
    }

    if (n == 0 || n == 1)
      return 1;
    else
      return (fibonacci(n - 1) + fibonacci(n - 2));
  }

}
