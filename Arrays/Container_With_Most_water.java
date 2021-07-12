package Arrays;
// Leetcode 11
// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
public class Container_With_Most_water {
    // Driver code
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("Container with most water is "+maxArea(heights));
    }
    // Function to calculate maximum area container .
    private static int maxArea(int[] heights) {
        int max_area = 0; // variable to store maximum area
        int left = 0; // pointer to access heights from left .
        int right = heights.length - 1; // point to access heights from right .

        // iterate until left is small than right pointer .
        while(left < right) {
            if(heights[left] < heights[right]) {
                max_area = Math.max(max_area,heights[left]*(right - left));
                left++;
            } else {
                max_area = Math.max(max_area , heights[right] * (right - left));
                right--;
            }
        }
        return max_area;
    }
}
