/*Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

 */
package Arrays;

public class FirstAndLastPositionOfElement {
    // Driver code
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8 ;
        int[] position = searchRange(nums,target);
        System.out.println("Positions are "+position[0]+", "+position[1]);
    }

    // Function to search range
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2] ;
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);

        return result;
    }

    // Binary search function to return first position of target element .
    public static int findLast(int[] nums , int target) {
        int low = 0 ;
        int high = nums.length-1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
                idx = mid;
            if(nums[mid] <= target)
                low = mid+1;
            else
                high = mid-1;
        }

        return idx;
    }
    public static int findFirst(int[] nums , int target) {
        int low = 0 ;
        int high = nums.length-1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
                idx = mid;
            if(nums[mid] >= target)
                high = mid-1;
            else
                low = mid+1;
        }

        return idx;
    }
}
