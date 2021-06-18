package Arrays;

public class ShortestSubarrayWithSumEqualtoTarget {
    public static int shortestsubarray(int[] nums , int target)
    {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int val_sum = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            val_sum += nums[i];
            while(val_sum >= target) {
                result = Math.min(result , i+1-left);
                val_sum -= nums[left];
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,3,4,7};
        int target = 7;
        System.out.println("Shortest subarray with sum equal to target : "+shortestsubarray(nums,target));
    }
}
