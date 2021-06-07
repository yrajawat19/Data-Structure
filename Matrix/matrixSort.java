package Matrix;
import java.util.*;
public class matrixSort {
    static void sort(int[][] matrix)
    {
        int n = matrix.length;
        int[] temp = new int[n*n];
        int k=0;
        // Storing elements of matrix into temp array
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                temp[k++] = matrix[i][j];
        // sorting an array
        Arrays.sort(temp);
        k = 0;
        // Storing element from temp array to matrix
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j] = temp[k++];
    }
    public static void print(int[][] matrix)
    {
        int n = matrix.length;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int matrix[][] = {{2,5,1},{3,7,4},{9,6,8},};
        System.out.println("Unsorted Arrays : ");
        print(matrix);
        sort(matrix);
        System.out.println("Sorted Arrays : ");
        print(matrix);

    }
}
