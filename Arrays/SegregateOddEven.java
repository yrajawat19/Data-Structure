package Arrays;

public class SegregateOddEven {
    // Driver code
    public static void main(String[] args) {
        int[] nums =  {12,35,56,2,6,4,3,8,5,9,13,15,16,191};
        System.out.println("Input array : ");
        print(nums);
        System.out.println("Array after segregating odd and evens : ");
        segregateArray(nums);
        print(nums);
    }

    // Function to print array
    private static void print(int[] nums) {
        for(int num : nums)
            System.out.print(num+" ");
        System.out.println();
    }

    // Function to segregate odd and evens in array .
    private static void segregateArray(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high) {
            while(nums[low]%2 == 0 && low < high)
                low++;
            while(nums[high]%2 == 1 && low < high)
                high--;
            if(low < high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
    }
}
