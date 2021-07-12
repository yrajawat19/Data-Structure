package Matrix;

import java.util.Arrays;

public class ReshapeTheMatrix {
    // Driver code
    public static void main(String[] args) {
        int[][] input_matrix = new int[2][4];
        for(int i = 0 ; i < input_matrix.length;i++) {
            for(int j = 0 ; j < input_matrix[0].length ; j++) {
                input_matrix[i][j] = i*10+j*20 +1;
            }
        }
        int[][] output_matrix = reshapeMatrix(input_matrix , 1, 8);
        System.out.println("Input matrix : ");
        print(input_matrix);
        System.out.println("Output matrix : ");
        print(output_matrix);

    }
    // Function to reshape the matrix
    private static int[][] reshapeMatrix(int[][] input_matrix, int r, int c) {
        int rows = input_matrix.length;
        int columns = input_matrix[0].length;
        int[][] output_matrix  = new int[r][c];
        int row_index = 0;
        int column_index = 0;

        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++) {
                output_matrix[row_index][column_index] = input_matrix[i][j];
                column_index++;
                if(column_index == c) {
                    column_index = 0;
                    row_index++;
                }
            }
        }
        return output_matrix;
    }

    // Function to print the matrix
    public static void print(int[][] mat) {
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
