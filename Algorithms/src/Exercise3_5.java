import java.util.Scanner;


public class Exercise3_5 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Integer[] myArray;
    Integer size, counter;
    Scanner in = new Scanner(System.in);

    // Reading the size of the array
    System.out.println("Enter the dimension of the array");
    size = Integer.valueOf(in.nextLine());
    myArray = new Integer[size];

    // Reading all the values of the array
    for (counter = 0; counter < size; counter++) {
      System.out.println("Enter the value number " + counter);
      myArray[counter] = Integer.valueOf(in.nextLine());

    }

    // Sorting the array
    bubbleSort(myArray, size);

    // Returning the sorted array
    System.out.println("The sorted array is:");
    for (counter = 0; counter < size; counter++) {
      System.out.print(myArray[counter] + " ");
    }

  }

  /**
   * Method sorting an array of size n
   * 
   * @param array
   * @param size
   */
  public static void bubbleSort(Integer array[], Integer size) {

    int counter1, counter2, swap;
    for (counter1 = 0; counter1 < size; counter1++) {
      for (counter2 = 1; counter2 < (size - counter1); counter2++) {
        if (array[counter2 - 1] > array[counter2]) {
          swap = array[counter2 - 1];
          array[counter2 - 1] = array[counter2];
          array[counter2] = swap;
        }
      }
    }

  }

}
