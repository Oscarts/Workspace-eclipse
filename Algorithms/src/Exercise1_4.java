import java.util.Scanner;



public class Exercise1_4 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Integer n, counter, fact;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a number");
    n = Integer.valueOf(in.nextLine());

    if (n < 0) {
      System.out.println("Enter a positive number");
      return;
    }

    fact = 1;
    for (counter = 2; counter <= n; counter++) {
      fact = fact * counter;
    }

    System.out.println("The factorial is " + fact);
  }

}
