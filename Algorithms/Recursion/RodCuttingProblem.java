package Algorithms.Recursion;

public class RodCuttingProblem {
    // Function to calculate maximum profit from rod cutting .
    public static int maximumProfit(int[] arr ,int n)
    {
        if( n <= 0)
            return 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++)
            max = Math.max(max,arr[i]+maximumProfit(arr,n-i-1));

        return max;
    }
    // Driver code
    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int  n = arr.length;
        System.out.println("Maximum profit from a rod is "+maximumProfit(arr,n));
    }
}
