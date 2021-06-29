package Arrays;

import java.util.Scanner;

public class MaximumSumCircularSubarray {
    // Function to return maximum sum in circular array .
    public static int maxSubarraySumCircular(int[] nums)
    {
        int nonCircularSum = KadaneMaxSum(nums); // Store maximum sum in non circular array .
        int totalSum = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            totalSum += nums[i] ;
            nums[i] = -nums[i];
        }

        int circularSum = totalSum - KadaneMaxSum(nums);
        if(circularSum == 0)
            return nonCircularSum;
        return Math.max(nonCircularSum , circularSum);
    }
    // Function to return maximum sum of subarray
    public static int KadaneMaxSum(int[] nums)
    {
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            if(currSum < 0)
                currSum = 0;
            currSum += nums[i];
            // store maximum sum in maxSum
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    // function to print array
    public static void print(int[] arr) {
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No of elements in array : ");
        int n = sc.nextInt();
        System.out.println("Enter elements in array : ");
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        System.out.println("Input array : ");
        print(arr);
        System.out.println("Maximum sum of subarray in Circular array is "+maxSubarraySumCircular(arr));
    }
}
