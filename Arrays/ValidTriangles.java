package Arrays;
import java.util.Arrays;
public class ValidTriangles {
    //Driver code
    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        System.out.println("Number of valid triangles in array : "+validtriangles(nums));
    }

    // Function to count valid triangles in array .
    public static int validtriangles(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length-1; i>= 2 ; i--) {
            int low = 0 ;
            int high = i-1;
            while(low < high) {
                if(nums[low] + nums[high] > nums[i]) {
                    count += high - low;
                    high--;
                } else low++;
            }
        }
        return count;
    }
}
