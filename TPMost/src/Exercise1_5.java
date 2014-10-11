import java.util.Scanner;


public class Exercise1_5 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Integer n, counter, upperBound;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a number");
    n = Integer.valueOf(in.nextLine());

    if (n < 0) {
      System.out.println("Enter a positive number");
      return;
    }
    upperBound = n / 2;
    for (counter = 2; counter < upperBound; counter++) {
      if (n % counter == 0) {
        System.out.println("The number is not prime");
        return;
      }
    }

    System.out.println("The number is prime");

  }

}
