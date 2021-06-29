package Algorithms.DP;
import java.util.Scanner;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // Function to calculate length of longest Increasing subsequence .
    public static int lis(int[] arr,int n) {
        // Copying arr into nums before sorting .
        int[] nums  = Arrays.copyOf(arr,n);
        // Sorting the array .
        Arrays.sort(arr);
        // creating 2D table for storing the answers to subproblems .
        int[][] table = new int[n+1][n+1];
        // Sorted Array must contain longest increasing subsequence which we can find by calculating
        // longest common subsequence from both the array .
        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j<= n ; j++) {
                if( i == 0 || j == 0)
                    table[i][j] = 0;
                else if(nums[i-1] == arr[j-1])
                    table[i][j] = table[i-1][j-1] + 1;
                else
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
            }
        }
        // returning the answer .
        return table[n][n];
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements in array : ");
        for(int i = 0; i< n;i++)
            nums[i] = sc.nextInt();
        System.out.println("Length of longest increasing subsequence is "+lis(nums,n));
    }
}
