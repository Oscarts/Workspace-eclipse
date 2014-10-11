import java.util.Scanner;



public class Exercise1_7 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Integer year, month, day, nbDays = -1;
    String s;

    // Reading date
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a date in the format YYYY/MM/DD");
    s = in.nextLine();

    // Transforming string to year, month and day
    year = Integer.valueOf(s.substring(0, 4));
    month = Integer.valueOf(s.substring(5, 7));
    day = Integer.valueOf(s.substring(8, 10));

    // Computing the number of days in a month
    switch (month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        nbDays = 31;
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        nbDays = 30;
        break;
      case 2:
        if (isLeap(year)) {
          nbDays = 29;
        } else {
          nbDays = 28;
        }
        break;
      default:
        System.out.println("Not a valid month");
        return;
    }

    // Computing tomorrow
    if (day > nbDays || day <1) {
      System.out.println("Not a valid day");
      return;
    }
    if (day != nbDays) {
      day++;
    } else {
      day = 1;
      if (month == 12) {
        month = 1;
        year++;
      } else {
        month++;
      }
    }

    // Returning the date
    System.out.println("Tomorrow will be " + year + "/" + month + "/" + day);

  }


  private static Boolean isLeap(Integer year) {
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
      return true;
    } else {
      return false;
    }

  }

}
