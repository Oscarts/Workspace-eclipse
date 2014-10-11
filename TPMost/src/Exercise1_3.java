import java.util.Scanner;


public class Exercise1_3 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    String myWord;
    Scanner in = new Scanner(System.in);

    // Reading the string
    System.out.println("Enter a string");
    myWord = in.nextLine();

    // Testing if it is a palindrom
    Boolean isPal = isPalindrome(myWord);

    // Printing the result
    if (isPal) {
      System.out.println("It is a palindrom");
    } else {
      System.out.println("It is not a palindrom");
    }
  }

  /**
   * Method returning true if myWord is a palindrom
   * 
   * @param myWord
   * @return
   */
  private static Boolean isPalindrome(String myWord) {

    Integer length = myWord.length();
    if (length <= 1) {
      return true;
    } else {
      String firstLetter = myWord.substring(0, 1);
      String lastLetter = myWord.substring(length - 1, length);

      return (firstLetter.compareTo(lastLetter) == 0 && isPalindrome(myWord.substring(1, length - 1)));
    }


  }

}
