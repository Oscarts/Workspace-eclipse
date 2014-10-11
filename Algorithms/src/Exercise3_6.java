import java.util.Scanner;



public class Exercise3_6 {

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
    mergeSort(myArray, 0, size - 1);

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
  public static void mergeSort(Integer array[], Integer low, Integer high) {

    int lowIndex = low;
    int highIndex = high;
    if (lowIndex >= highIndex) {
      return;
    }

    // Merging into two sub-arrays
    int middle = (lowIndex + highIndex) / 2;
    mergeSort(array, lowIndex, middle);
    mergeSort(array, middle + 1, highIndex);

    int endLow = middle;
    int startHigh = middle + 1;
    while ((low <= endLow) && (startHigh <= highIndex)) {
      if (array[lowIndex] < array[startHigh]) {
        lowIndex++;
      } else {
        int Temp = array[startHigh];
        for (int k = startHigh - 1; k >= lowIndex; k--) {
          array[k + 1] = array[k];
        }
        array[lowIndex] = Temp;
        lowIndex++;
        endLow++;
        startHigh++;
      }
    }

  }


}
