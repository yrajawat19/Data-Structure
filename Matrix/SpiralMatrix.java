package Matrix;
import java.lang.reflect.Array;
import java.util.*;
public class SpiralMatrix {
    private static ArrayList<Integer> spiralMatrix (int[][] matrix)
    {
        ArrayList<Integer> nums = new ArrayList<>();
        int n = matrix.length;
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int dir = 0;
        if(n == 0)
            return nums;
        while(left <= right && top <= down) {
            if(dir == 0)
            {
                for(int i=left;i<=right;i++)
                    nums.add(matrix[top][i]);
                    top++;
            }
            else if(dir == 1)
            {
                for(int i=top;i<=down;i++)
                    nums.add(matrix[i][right]);
                    right--;
            }
            else if(dir == 2)
            {
                for(int i=right;i>=left;i--)
                    nums.add(matrix[down][i]);
                    down--;
            }
            else if(dir == 3)
            {
                for(int i=down;i>=top;i--)
                    nums.add(matrix[i][left]);
                    left++;
            }

            dir = (dir+1)%4;
        }

        return nums;
    }
    private static void printList(ArrayList<Integer> list)
    {
        for(int i:list)
            System.out.print(i+" ");
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = spiralMatrix(matrix);
        printList(list);
    }

}
