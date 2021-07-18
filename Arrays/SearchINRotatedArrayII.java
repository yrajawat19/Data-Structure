/*There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums */
package Arrays;
public class SearchINRotatedArrayII{
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1,};
        int target = 2;
        System.out.println(search(nums,target));
    }

    public static boolean search(int[] nums , int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] < nums[start] || nums[mid] < nums[end]) {
                if(nums[mid] < target && target <= nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            } else if(nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if(nums[mid] > target && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid+1;
            }
            else
                end--;
        }

        return false;
    }
}
