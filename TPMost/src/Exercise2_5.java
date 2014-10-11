

import java.util.Scanner;


public class Exercise2_5 {

  public static void main(String[] args) {

    System.out.println("TEST 1 : SHOULD BE 3 WITH AN OCCURRENCE OF 1");
    Integer[] values_1 = new Integer[5];
    values_1[0] = 0;
    values_1[1] = 0;
    values_1[2] = 3;
    values_1[3] = 1;
    values_1[4] = 1;
    findValueWithLeastOccurrence(values_1);

    System.out.println("TEST 2 : SHOULD BE 42 WITH AN OCCURRENCE OF 2");
    Integer[] values_2 = new Integer[5];
    values_2[0] = 42;
    values_2[1] = 0;
    values_2[2] = 0;
    values_2[3] = 0;
    values_2[4] = 42;
    findValueWithLeastOccurrence(values_2);

    System.out.println("TEST 4 : USER TEST");
    // --- An array of many values to check the behavior
    Integer[] array_user = userInputArray();
    findValueWithLeastOccurrence(array_user);
  }

  private static void findValueWithLeastOccurrence(Integer[] values) {
    // --- Initializes the variable
    Integer valueWithSmallestOccurrences = values[0];
    Integer leastNbOccurrences = values.length;

    // --- Loop on the array of values
    Integer nbValues = values.length;
    for (int position = 0; position < nbValues; position++) {
      Integer nbOccurrences = countOccurrences(values[position], values);
      if (nbOccurrences < leastNbOccurrences) {
        leastNbOccurrences = nbOccurrences;
        valueWithSmallestOccurrences = values[position];
      }
    }
    printMessage(valueWithSmallestOccurrences, leastNbOccurrences);
  }

  private static Integer countOccurrences(Integer value, Integer[] values) {
    // --- Initialization of variables
    Integer nbOccurrence = 0;

    // --- Loop on the array of values
    Integer nbValues = values.length;
    for (int position = 0; position < nbValues; position++) {
      if (value == values[position]) {
        // --- Increase the number of occurrences
        nbOccurrence++;
      }
    }
    return nbOccurrence;
  }

  private static void printMessage(Integer value, Integer occurrences) {
    System.out.println(value + " is the element which has the smallest number of occurrences: " + occurrences);
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
