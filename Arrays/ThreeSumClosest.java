package Arrays;
import java.util.Arrays;
public class ThreeSumClosest {
    // Driver code
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        int targetSum = 1 ;
        System.out.println("Closest sum to target in array is "+closest3Sum(arr,targetSum));
    }

    public static int closest3Sum(int[] nums , int target) {
        int Sum = nums[0] + nums[1] + nums[nums.length -1];
        int closestSum = Sum ;

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {
                Sum = nums[i]+nums[start]+nums[end];
                if(Sum < target)
                    start++;
                else
                    end        --;

                if(Math.abs(Sum-target) < Math.abs(closestSum-target))
                    closestSum = Sum;
            }
        }

        return closestSum;
    }
}
