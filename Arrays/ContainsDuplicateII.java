/* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.*/
package Arrays;
import java.util.HashSet;
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++) {
            if(i>k)
                set.remove(nums[i-k-1]);
            if(!set.add(nums[i]))
                return true;
        }

        return false;
    }
}
