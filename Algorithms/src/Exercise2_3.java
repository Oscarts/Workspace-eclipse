

import java.util.Scanner;


public class Exercise2_3 {

  public static void main(String[] args) {

    System.out.println("TEST 1 : SHOULD BE 0 NEGATIVE VALUES");
    Integer[] values_1 = new Integer[3];
    values_1[0] = 0;
    values_1[1] = 1;
    values_1[2] = 2;
    Integer nbNegativeValues_1 = countAndPrintNegativeValues(values_1);
    printMessage(nbNegativeValues_1);

    System.out.println("TEST 2 : SHOULD BE 3 NEGATIVE VALUES");
    Integer[] values_2 = new Integer[3];
    values_2[0] = -1;
    values_2[1] = -21;
    values_2[2] = -2;
    Integer nbNegativeValues_2 = countAndPrintNegativeValues(values_2);
    printMessage(nbNegativeValues_2);

    System.out.println("TEST 3 : SHOULD BE 1 NEGATIVE VALUES");
    Integer[] values_3 = new Integer[3];
    values_3[0] = 0;
    values_3[1] = -21;
    values_3[2] = 12;
    Integer nbNegativeValues_3 = countAndPrintNegativeValues(values_3);
    printMessage(nbNegativeValues_3);

    System.out.println("TEST 4 : USER TEST");
    Integer[] array_user = userInputArray();
    Integer nbNegativeValuesUser = countAndPrintNegativeValues(array_user);
    printMessage(nbNegativeValuesUser);
  }

  private static Integer countAndPrintNegativeValues(Integer[] values) {
    // --- Initializes the variable
    Integer nbNegativeValues = 0;

    // --- Loop on the array of values
    Integer nbValues = values.length;
    for (int position = 0; position < nbValues; position++) {
      // --- Case of a negative value
      if (values[position] < 0) {
        System.out.println("A negative value has been found !! " + values[position]);

        // --- Increase the number of negative values
        nbNegativeValues++;
      }
    }
    return nbNegativeValues;
  }

  private static void printMessage(Integer nbNegativeValues) {
    System.out.println("There are " + nbNegativeValues + " negative values inside the given array of values !!");
    System.out.println("Ready for next test!! \n\n");
  }

  private static Integer[] userInputArray() {
    Scanner in = new Scanner(System.in);
    System.out.println("\n\nEnter the number of values");
    Integer nbGrades = Integer.valueOf(in.nextLine());

    Integer[] grades = new Integer[nbGrades];
    for (int position = 0; position < nbGrades; position++) {
      System.out.println("Enter the value " + position);
      grades[position] = Integer.valueOf(in.nextLine());
    }
    return grades;
  }

}
