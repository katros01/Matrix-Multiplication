import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static void insertValues(int[][] matrix, int numberRow, int numberCol){
        for (int x = 0; x< numberRow; x++){
            for(int y = 0; y< numberCol; y++){
                matrix[x][y] = input.nextInt();
            }
        }
    }

    static int[][] multiplyMatrix(int rowA, int colA, int colB, int[][] a, int[][] b){
        int[][] result = new int[rowA][colB];
        for(int i = 0; i< rowA; i++) {
             for(int j = 0; j< colB; j++) {
               result[i][j] = 0;
               for(int x = 0; x < colA; x++) {
                   result[i][j] = result[i][j] + a[i][x] * b[x][j];
               }
             }
        }

        return  result;
    }
    public static void main(String[] args) {

        System.out.print("Enter number of rows for Matrix A: ");
        int numberRow1 = input.nextInt();

        System.out.print("Enter number of columns for Matrix A: ");
        int numberCol1 = input.nextInt();

        System.out.print("Enter number of rows for Matrix B: ");
        int numberRow2 = input.nextInt();

        System.out.print("Enter number of columns for Matrix B: ");
        int numberCol2 = input.nextInt();
        int[][] matrix1 = new int[numberRow1][numberCol1];
        int[][] matrix2 = new int[numberRow2][numberCol2];

        System.out.println("\n");
        if(numberCol1 != numberRow2){
            System.out.println("Can't multiply this matrix!! The number of columns for Matrix A must equal to the number of rows of Matrix B");
        } else {
            System.out.println("Enter values Matrix A: " + numberRow1 + "," + numberCol1);
            insertValues(matrix1, numberRow1, numberCol1);

            System.out.println("\n");
            System.out.println("Enter values Matrix B: "+ numberRow2 + "," + numberCol2);
            insertValues(matrix2, numberRow2, numberCol2);

           int[][] result = multiplyMatrix(numberRow1, numberCol1, numberCol2, matrix1, matrix2);
            System.out.println("\n");
            System.out.println("Matrix C:\n");
           for (int x = 0; x< numberRow1; x++){
                   System.out.print("|\t");
                   for(int y = 0; y< numberCol2; y++){
                   System.out.print(result[x][y]+ "\t");
               }

               System.out.print("|");
               System.out.println();

           }
        }
    }
}