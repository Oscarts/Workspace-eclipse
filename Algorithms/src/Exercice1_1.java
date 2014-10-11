import java.util.Scanner;



public class Exercice1_1 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner in = new Scanner(System.in);
    String s1, s2;
    System.out.println("Print first string");
    s1 = in.nextLine();

    System.out.println("Print second string");
    s2 = in.nextLine();

    if (s1.compareTo(s2) < 0) {
      System.out.println(s1 + " " + s2);
    } else {
      System.out.println(s2 + " " + s1);

    }

  }

}
