public class Kadane_Algorithm
{
    public static void main(String[] args) {
        int[] a = {-1, -3, 5, 7, -4, 8, -5};
        System.out.print("Maximum contiguous subarray sum is " + maxSubarraySum(a));

    }
    public static int maxSubarraySum(int a[])
    {
        int size = a.length;
        int max_so_far = a[0];
        int max_ending_here = 0;
        for( int i=0;i<size;i++)
        {
            max_ending_here+=a[i];
            if(max_ending_here>max_so_far)
                max_so_far=max_ending_here;
            if(max_ending_here < 0)
                max_ending_here = 0 ;
        }
        return max_so_far;
    }
}