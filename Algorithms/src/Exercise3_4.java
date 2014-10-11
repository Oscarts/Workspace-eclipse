import java.util.Scanner;



public class Exercise3_4 {

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
    selectionSort(myArray, size);

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
  public static void selectionSort(Integer array[], Integer size) {
    Integer position, counter, indexMin, swap;
    for (position = 0; position < size; position++) {
      indexMin = position;
      for (counter = position; counter < size; counter++) {
        if (array[indexMin] > array[counter]) {
          indexMin = counter;
        }
      }
      swap = array[position];
      array[position] = array[indexMin];
      array[indexMin] = swap;
    }
  }

}
