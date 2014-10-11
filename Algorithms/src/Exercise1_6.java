import java.util.Scanner;


public class Exercise1_6 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Integer year;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a year after 1582");
    year = Integer.valueOf(in.nextLine());

    while (year < 1582) {
      System.out.println("Error ! Enter a year after 1582");
      year = Integer.valueOf(in.nextLine());
    }


    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
      System.out.println("It is a leap year");
    } else {
      System.out.println("It is not a leap year");
    }

  }

}
