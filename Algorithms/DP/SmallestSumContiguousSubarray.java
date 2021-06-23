package Algorithms.DP;

public class SmallestSumContiguousSubarray {
    public static int smallestSum(int[] arr)
    {
        int min_ending_here = Integer.MAX_VALUE;
        int min_so_far = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(min_ending_here > 0)
                min_ending_here = arr[i];
            else
                min_ending_here += arr[i];

            min_so_far = Math.min(min_so_far,min_ending_here);
        }
        return min_so_far;
    }
    public static void main(String[] args) {
        int[] arr =  {3, -4, 2, -3, -1, 7, -5};
        System.out.println("Smallest Sum in array : "+smallestSum(arr));
    }
}
