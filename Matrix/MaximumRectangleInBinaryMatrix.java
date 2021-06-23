package Matrix;

import java.util.Stack;

public class MaximumRectangleInBinaryMatrix {
    public static int largestRectangleArea(int[][] matrix) {
        int rows = matrix.length; // no of rows in matrix
        int columns = matrix[0].length; // no of columns in matrix
        int[] heights = new int[columns]; // height array to store heights of rectangles
        int maxArea = 0; // max area
        for(int i : heights)
            i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1)
                    heights[j] += 1;
                else
                    heights[j] = 0;

            }
            int[] left = new int[columns];
            int[] right = new int[columns];

            for (int k = 0; k < columns; k++) {
                if (stack.isEmpty())
                    left[k] = 0;
                else {
                    while (!stack.isEmpty() && heights[stack.peek()] >= heights[k])
                        stack.pop();
                    left[k] = stack.isEmpty() ? 0 : stack.peek() + 1;
                }
                stack.push(k);
            }

            stack.clear();

            for (int k = columns - 1; k >= 0; k--) {
                if (stack.isEmpty())
                    right[k] = columns - 1;
                else {
                    while (!stack.isEmpty() && heights[stack.peek()] >= heights[k])
                        stack.pop();
                    right[k] = stack.isEmpty() ? columns - 1 : stack.peek() - 1;
                }
                stack.push(k);
            }

            for (int k = 0; k < columns; k++) {
                int area = (right[k] - left[k] + 1) * heights[k];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,0,0,0}};
        System.out.println("Area of largest rectangle in binary matrix is "+largestRectangleArea(matrix));
    }
}
