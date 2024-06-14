import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static void insertValues(int[][] matrix, int numberRow, int numberCol){   //insert values from user
        for (int x = 0; x< numberRow; x++){
            for(int y = 0; y< numberCol; y++){
                if(!input.hasNextInt()){ // validate inputs
                    System.out.println("the value you entered on index (" + x + "," + y + ") is not a number!"  );
                    input.next();
                }

                matrix[x][y] = input.nextInt();
            }
        }
    }

    static int[][] multiplyMatrix(int rowA, int colA, int colB, int[][] a, int[][] b){      // calculate multiplication of Matrix A and Matrix B
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
        int numberRowA = input.nextInt();

        System.out.print("Enter number of columns for Matrix A: ");
        int numberColA = input.nextInt();

        System.out.print("Enter number of rows for Matrix B: ");
        int numberRowB = input.nextInt();

        System.out.print("Enter number of columns for Matrix B: ");
        int numberColB = input.nextInt();

        int[][] matrixA = new int[numberRowA][numberColA];
        int[][] matrixB = new int[numberRowB][numberColB];

        System.out.println("\n");
        if(numberColA != numberRowB){
            System.out.println("Can't multiply this matrix!! The number of columns for Matrix A must equal to the number of rows of Matrix B");
        } else {
            System.out.println("Enter values Matrix A: " + numberRowA + "," + numberColA);
            insertValues(matrixA, numberRowA, numberColA);

            System.out.println("\n");
            System.out.println("Enter values Matrix B: "+ numberRowB + "," + numberColB);
            insertValues(matrixB, numberRowB, numberColB);

           int[][] matrixC = multiplyMatrix(numberRowA, numberColA, numberColB, matrixA, matrixB);

            System.out.println("\n");
            System.out.println("Matrix C:\n");

           for (int x = 0; x< numberRowA; x++){
                   System.out.print("|\t");
                   for(int y = 0; y< numberColB; y++){
                   System.out.print(matrixC[x][y]+ "\t");
               }

               System.out.print("|");
               System.out.println();

           }
        }
    }
}