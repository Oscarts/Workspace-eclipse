import java.util.Scanner;


public class Exercise3_2 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Integer n, fact;

    // Read the number
    System.out.println("Print a number");
    n = Integer.valueOf(in.nextLine());

    // Compute the factorial
    fact = factorial(n);

    // Return the factorial
    if (fact != null) {
      System.out.println("The fact number is " + fact);
    }
  }

  /**
   * Method returning the factorial of a number n
   * 
   * @param n
   * @return
   */
  private static Integer factorial(Integer n) {
    if (n < 0) {
      System.out.println("Please enter a positive integer");
      return null;
    }

    if (n == 0 || n == 1)
      return 1;
    else
      return (n * factorial(n - 1));
  }

}
