package Arrays;
import java.util.*;
public class FourSum {
    // Driver code
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println("Quadraplets with given target sum : ");
        System.out.println(quadraplets(nums,target));
    }

    // Function to return all quadraplets from array .
    public static List<List<Integer>> quadraplets(int[] nums , int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4)
            return result ;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ; i++) {
            if( i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1; j <nums.length ; j++) {
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                int t = target-nums[i]-nums[j];
                int low = j+1;
                int high = nums.length-1;
                while(low < high) {
                    if(nums[low]+nums[high] == t) {
                        Integer[] temp = {nums[i],nums[j],nums[low],nums[high]};
                        result.add(Arrays.asList(temp));
                        low++;
                        high--;
                        while( low < nums.length && nums[low] == nums[low-1])
                            low++;
                        while( high >= 0 && nums[high] == nums[high+1])
                            high--;
                    } else if(nums[low]+nums[high] < t)
                        low++;
                    else
                        high--;
                }
            }
        }

        return result;
    }
}
