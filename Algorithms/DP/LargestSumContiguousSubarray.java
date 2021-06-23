package Algorithms.DP;

public class LargestSumContiguousSubarray {
    public static int largestSum(int[] arr)
    {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            max_ending_here += arr[i];
            max_so_far = Math.max(max_so_far,max_ending_here);
            if(max_ending_here < 0)
                max_ending_here = 0;
        }

        return max_so_far;
    }
    public static void main(String[] args) {
        int[] arr = {3, -4, 2, -3, -1, 7, -5};
        System.out.println("Largest sum of subarray is "+largestSum(arr));
    }
}
