

import java.util.Scanner;


public class Exercise2_4 {

  public static void main(String[] args) {
    Integer target = 10;

    System.out.println("TEST 1 : SHOULD BE 10 WITH A DISTANCE OF 0");
    Integer[] values_1 = new Integer[5];
    values_1[0] = 0;
    values_1[1] = 10;
    values_1[2] = 20;
    values_1[3] = 9;
    values_1[4] = 11;
    Integer closest_1 = findClosest(target, values_1);
    printMessage(target, closest_1);

    System.out.println("TEST 2 : SHOULD BE 11 WITH A DISTANCE OF 1");
    Integer[] values_2 = new Integer[5];
    values_2[0] = -1;
    values_2[1] = -21;
    values_2[2] = -2;
    values_2[3] = 11;
    values_2[4] = 42;
    Integer closest_2 = findClosest(target, values_2);
    printMessage(target, closest_2);

    System.out.println("TEST 3 : SHOULD BE 9 WITH A DISTANCE OF 1");
    Integer[] values_3 = new Integer[5];
    values_3[0] = 8;
    values_3[1] = -21;
    values_3[2] = 9;
    values_3[3] = -2;
    values_3[4] = 12;
    Integer closest_3 = findClosest(target, values_3);
    printMessage(target, closest_3);

    System.out.println("TEST 4 : USER TEST");
    Integer[] array_user = userInputArray();
    Integer closestUser = findClosest(target, array_user);
    printMessage(target, closestUser);
  }

  private static Integer findClosest(Integer target, Integer[] values) {
    // --- Initialization of variables
    Integer closest = values[0];
    Integer smallestDistance = Math.abs(closest - target);

    // --- Loop on the array of values
    Integer nbValues = values.length;
    for (int position = 0; position < nbValues; position++) {
      Integer currentDistance = Math.abs(values[position] - target);
      if (currentDistance < smallestDistance) {
        // --- Save the current element as the closest one
        closest = values[position];

        // --- Save the current distance as the smallest one
        smallestDistance = currentDistance;
      }
    }
    return closest;
  }

  private static void printMessage(Integer target, Integer closest) {
    Integer distance = Math.abs(target - closest);
    System.out.println(closest + " is the closest element to " + target + " with a distance of " + distance);
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
