package Matrix;

import java.util.Scanner;

public class MatrixRightRotation {

    // Function to print matrix
    public static void print(int[][] matrix , int N)
    {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0; j < N ; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }

    // Function to clockwise rotate an image
    public static void rightRotate(int[][] matrix , int N)
    {
        // Transpose of matrix
        for(int i = 0 ; i < N; i++) {
            for(int j = i ; j< N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // We will reverse the transposed matrix
        for(int i = 0 ; i < N ; i++) {
            int left = 0;
            int right = N-1;
            while(left<right)
            {
              int temp = matrix[i][left];
              matrix[i][left] = matrix[i][right];
              matrix[i][right] = temp;
              left++;
              right--;
            }
        }
        // printing the matrix
        System.out.println("Clockwise rotated matrix : ");
        print(matrix,N);
    }

    //Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rows in matrix : ");
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        System.out.println("Enter elements in matix :");
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N; j++)
                matrix[i][j] = sc.nextInt();
        }
        System.out.println("Input Matrix : ");
        print(matrix,N);
        rightRotate(matrix,N);

    }
}
