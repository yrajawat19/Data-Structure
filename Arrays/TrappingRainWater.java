package Arrays;

public class TrappingRainWater {
    // function to calculate total area to trap water .
    public static int trappedWaterArea(int[] heights) {
        int n = heights.length; // height array size .
        int[] left = new int[n]; // left array to store maximum height of left size .
        int[] right = new int[n]; // right array to store maximum height of right size .
        int water = 0; // water to store total trapped water
        left[0] = heights[0];
        for(int i = 1 ; i < n ; i++)
            left[i] = Math.max(left[i-1],heights[i]);
        right[n-1] = heights[n-1];
        for(int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1],heights[i]);

        for(int i = 0 ; i < n ; i++)
         water += Math.min(right[i],left[i]) - heights[i];

        return water;
    }
    // Driver code
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Area for trapped water : "+trappedWaterArea(heights));
    }
}
