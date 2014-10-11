

import java.util.Scanner;


public class Exercise2_2 {

  public static void main(String[] args) {

    System.out.println("TEST 1 : SHOULD BE MAGIC");
    Integer[][] matrix_1 = new Integer[3][3];
    matrix_1[0][0] = 0;
    matrix_1[1][0] = 1;
    matrix_1[2][0] = 2;
    matrix_1[0][1] = 1;
    matrix_1[1][1] = 2;
    matrix_1[2][1] = 0;
    matrix_1[0][2] = 2;
    matrix_1[1][2] = 0;
    matrix_1[2][2] = 1;
    Boolean isMatrix_1_Magic = isMagic(matrix_1);
    printMessage(isMatrix_1_Magic);

    System.out.println("TEST2 : SHOULD NOT BE MAGIC");
    Integer[][] matrix_2 = new Integer[3][3];
    matrix_2[0][0] = 0;
    matrix_2[1][0] = 0;
    matrix_2[2][0] = 0;
    matrix_2[0][1] = 1;
    matrix_2[1][1] = 2;
    matrix_2[2][1] = 0;
    matrix_2[0][2] = 2;
    matrix_2[1][2] = 0;
    matrix_2[2][2] = 1;
    Boolean isMatrix_2_Magic = isMagic(matrix_2);
    printMessage(isMatrix_2_Magic);

    System.out.println("TEST 5 : USER TEST");
    Integer[][] matrix_user = userInputSquareMatrix();
    Boolean isMatrixUser_Magic = isMagic(matrix_user);
    printMessage(isMatrixUser_Magic);
  }

  private static Boolean isMagic(Integer[][] matrix) {
    Integer nbRow = matrix.length;
    Integer nbCol = matrix[0].length;

    // --- Compute the sum the first column
    Integer memorySum = 0;
    for (int row = 0; row < nbRow; row++) {
      memorySum = memorySum + matrix[row][0];
    }

    // --- Compute the sum of each row
    for(int row=0; row<nbRow; row ++){
      Integer sumRow = 0;
      for(int col=0; col<nbCol; col ++){
        sumRow = sumRow + matrix[row][col];
      } 
      if (sumRow != memorySum) {
        // --- The matrix is not magic !!
        return false;
      }
    }

    // --- Compute the sum of each col
    for (int col = 0; col < nbCol; col++) {
      Integer sumRow = 0;
      for (int row = 0; row < nbRow; row++) {
        sumRow = sumRow + matrix[row][col];
      }
      if (sumRow != memorySum) {
        // --- The matrix is not magic !!
        return false;
      }
    }

    // --- Compute the sum of the two diagonals
    Integer sumDiag = 0;
    for (int row = 0; row < nbRow; row++) {
      sumDiag = sumDiag + matrix[row][row];
    }
    if (sumDiag != memorySum) {
      // --- The matrix is not magic !!
      return false;
    }

    // --- If the previous tests succeeds, it is a magic square
    return true;
  }

  private static void printMessage(Boolean isMagic) {
    if (isMagic) {
      System.out.println("The matrix is magic !!");
    } else {
      System.out.println("The matrix is not magic !!");
    }
    System.out.println("ready for next test!! \n\n");
  }

  private static Integer[][] userInputSquareMatrix() {
    Scanner in = new Scanner(System.in);
    System.out.println("\n\nEnter the size of the matrix");
    Integer size = Integer.valueOf(in.nextLine());

    Integer[][] matrix = new Integer[size][size];
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        System.out.println("Enter the value of matrix[" + row + "][" + col + "] ");
        matrix[row][col] = Integer.valueOf(in.nextLine());
      }
    }
    return matrix;
  }

}
