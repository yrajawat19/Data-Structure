package Matrix;

import java.util.PriorityQueue;

public class KthSmallestElementInMatrix {
    // Driver code
    public static void main(String[] args) {
        int[][] matrix = {{2,5,7,9},{12,14,16,19},{22,55,89,105}};
        int K = 8;
        print(matrix);
        System.out.println(K+"th smallest number in matrix is "+KthSmallestNumber(matrix,K));
    }
    // Function to return Kth smallest element from matrix .
    static int KthSmallestNumber(int[][] matrix , int K) {
        // Push all elements in Min heap and extract k elements from it .
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
            }
        }

        while(--K > 0)
            pq.poll();

        return pq.peek();

    }
    // Function to print matrix
    static void print(int[][] matrix) {
        System.out.println("Input Matrix : ");
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
