package Stacks;
import java.util.*;
public class LargestRectangleAreaInHistogram {
    public static int largestArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n ; i++)
        {
            if(stack.isEmpty())
                left[i] = 0;
            else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                    stack.pop();
                left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = n-1; i>=0; i--) {
            if(stack.isEmpty())
                right[i] = n-1;
            else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                    stack.pop();
                right[i] = stack.isEmpty() ? n-1 : stack.peek() -1;
            }
            stack.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int area = (right[i] - left[i] + 1) * heights[i];
            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println("Largest area of a rectangle in histogram is "+largestArea(heights));
    }
}
