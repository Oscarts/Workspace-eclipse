

import java.util.Scanner;


public class Exercise2_7 {

  public static void main(String[] args) {

    System.out.println("TEST 1 : SHOULD BE [1, 2, 3] WITH A SUM OF 6");
    Integer[] values_1 = new Integer[5];
    values_1[0] = -1;
    values_1[1] = 1;
    values_1[2] = 2;
    values_1[3] = 3;
    values_1[4] = 5;
    findSerieOfConsecutiveValuesWithBiggestSum(values_1);

    System.out.println("TEST 2 : SHOULD BE [6] WITH A SUM OF 6");
    Integer[] values_2 = new Integer[5];
    values_2[0] = 1;
    values_2[1] = 0;
    values_2[2] = 3;
    values_2[3] = 6;
    values_2[4] = -20;
    findSerieOfConsecutiveValuesWithBiggestSum(values_2);

    System.out.println("TEST 2 : SHOULD BE [5, 6] WITH A SUM OF 11");
    Integer[] values_3 = new Integer[5];
    values_3[0] = 1;
    values_3[1] = 2;
    values_3[2] = 3;
    values_3[3] = 5;
    values_3[4] = 6;
    findSerieOfConsecutiveValuesWithBiggestSum(values_3);

    System.out.println("TEST 4 : USER TEST");
    // --- An array of many values to check the behavior
    Integer[] array_user = userInputArray();
    findSerieOfConsecutiveValuesWithBiggestSum(array_user);
  }

  private static void findSerieOfConsecutiveValuesWithBiggestSum(Integer[] values) {
    // --- Initializes the variables (used to store the longest series)
    Integer biggestSum = values[0];
    Integer lastValue = values[0];
    String valuesInLongestSeries = "" + values[0];

    // --- Initializes the variables (used to store the current series)
    Integer currentSum = values[0];
    String currentSerie = "" + values[0];

    // --- Loop on the array of values
    Integer nbValues = values.length;
    for (int position = 1; position < nbValues; position++) {
      // --- If it is consecutive, go on with the next value
      if (values[position] == lastValue + 1) {
        currentSum = currentSum + values[position];
        currentSerie = currentSerie + ", " + values[position];
      }
      // --- If it is not, then update the series with biggest sum and start
      // another one
      if (values[position] != lastValue + 1) {
        // --- Update the series with biggest sum
        if (currentSum > biggestSum) {
          biggestSum = currentSum;
          valuesInLongestSeries = currentSerie;
        }
        // --- Start a new series
        currentSum = values[position];
        lastValue = values[position];
        currentSerie = "" + values[position];
      }
      lastValue = values[position];
    }
    // --- Checks the last series
    if (currentSum > biggestSum) {
      biggestSum = currentSum;
      valuesInLongestSeries = currentSerie;
    }
    printMessage(valuesInLongestSeries, biggestSum);
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

  private static void printMessage(String series, Integer sum) {
    System.out.println(series + " is the series of consecutive elements with the biggest sum: " + sum);
    System.out.println("Ready for next test!! \n\n");
  }

}
