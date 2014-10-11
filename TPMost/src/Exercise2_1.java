

import java.util.Scanner;


public class Exercise2_1 {

  public static void main(String[] args) {

    System.out.println("TEST 1 : SHOULD BE FAILURE WITH 2");
    Integer[] grades_1 = new Integer[3];
    grades_1[0] = 0;
    grades_1[1] = 2;
    grades_1[2] = 4;
    Double mean_1 = computeMean(grades_1);
    printMessage(mean_1);

    System.out.println("TEST 2 : SHOULD BE REMEDIAL LESSONS WITH 7");
    Integer[] grades_2 = new Integer[3];
    grades_2[0] = 5;
    grades_2[1] = 7;
    grades_2[2] = 9;
    Double mean_2 = computeMean(grades_2);
    printMessage(mean_2);

    System.out.println("TEST 3 : SHOULD BE ACCEPTED WITH 15");
    Integer[] grades_3 = new Integer[3];
    grades_3[0] = 13;
    grades_3[1] = 15;
    grades_3[2] = 17;
    Double mean_3 = computeMean(grades_3);
    printMessage(mean_3);

    System.out.println("TEST 4 : SHOULD BE ACCEPTED WITH HONOR WITH 17");
    Integer[] grades_4 = new Integer[3];
    grades_4[0] = 15;
    grades_4[1] = 17;
    grades_4[2] = 19;
    Double mean_4 = computeMean(grades_4);
    printMessage(mean_4);

    System.out.println("TEST 5 : USER TEST");
    Integer[] grades_user = userInputArray();
    Double meanUser = computeMean(grades_user);
    printMessage(meanUser);

  }

  private static Double computeMean(Integer[] grades) {

    // --- Compute the sum
    Double sum = 0.0;

    // --- Loop on the array of values
    Integer nbGrades = grades.length;
    for (int position = 0; position < nbGrades; position++) {
      sum = sum + grades[position];
    }
    // --- Compute and return the mean
    return sum / nbGrades;
  }

  private static void printMessage(Double mean) {
    System.out.println("Mean is: " + mean);

    Integer roundedMean = (int) Math.round(mean);
    System.out.println("Rounded mean is: " + roundedMean);
    if (roundedMean >= 0 && roundedMean <= 20) {
      // --- Case failure
      if (roundedMean < 5) {
        System.out.println("Comment: Failure");
      } else {
        // --- Case remedial lessons
        if (roundedMean < 10) {
          System.out.println("Comment: Remedial lessons");
        } else {
          // --- Case accepted
          if (roundedMean < 15) {
            System.out.println("Comment: Accepted");
          } else {
            // --- Case honor
            System.out.println("Comment: Accepted with honor");
          }
        }
      }
    } else {
      System.out.println("The mean should be between 0 and 20 !! ");
    }
    System.out.println("ready for next test!! \n\n");
  }

  private static Integer[] userInputArray() {
    Scanner in = new Scanner(System.in);

    // --- First defines the size of the array
    System.out.println("\n\nEnter the number of grades");
    Integer nbGrades = Integer.valueOf(in.nextLine());

    // --- Then fills the array
    Integer[] grades = new Integer[nbGrades];
    for (int position = 0; position < nbGrades; position++) {
      System.out.println("Enter the grade " + position);
      grades[position] = Integer.valueOf(in.nextLine());
    }
    return grades;
  }

}
