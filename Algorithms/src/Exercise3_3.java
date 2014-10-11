import java.util.Scanner;


public class Exercise3_3 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Integer[] sortedArray;
    Integer value, size, counter;
    Integer lowerBound, upperBound, middle;
    Scanner in = new Scanner(System.in);

    // Reading the size of the array
    System.out.println("Enter the dimension of the array");
    size = Integer.valueOf(in.nextLine());
    sortedArray = new Integer[size];

    // Reading all the values of the array
    for (counter = 0; counter < size; counter++) {
      System.out.println("Enter the value number " + counter);
      sortedArray[counter] = Integer.valueOf(in.nextLine());

      if (counter != 0) {
        if (sortedArray[counter] < sortedArray[counter - 1]) {
          System.out.println("Not in good order");
          return;
        }
      }
    }

    // Reading the value to be compared
    System.out.println("Enter the value i");
    value = Integer.valueOf(in.nextLine());

    // Dichotomic search
    lowerBound = 0;
    upperBound = size - 1;
    do {
      middle = (lowerBound + upperBound) / 2;
      if (sortedArray[middle] == value) {
        System.out.println("found ! in position " + middle + " the value is " + sortedArray[middle]);
        return;
      }
      if (sortedArray[middle] < value) {
        lowerBound = middle;
      } else {
        upperBound = middle;
      }
    } while (upperBound - lowerBound > 1);

    // Looking for the closiest value
    if (Math.abs(sortedArray[lowerBound] - value) < Math.abs(sortedArray[upperBound] - value)) {
      System.out.println("The closiest is in position " + lowerBound + " the value is " + sortedArray[lowerBound]);

    } else {
      System.out.println("The closiest is in position " + upperBound + " the value is " + sortedArray[upperBound]);

    }

  }

}
