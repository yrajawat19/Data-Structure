package Stacks;

import java.util.Stack;

public class NextSmallerElement {
    public static void findNSE(int[] nums)
    {
        Stack<Integer> s = new Stack<>();
        int[] NSE = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            if(!s.isEmpty())
            {
                while(!s.empty() && s.peek() >= nums[i])
                    s.pop();
                if(s.empty())
                    NSE[i] = -1;
                else
                    NSE[i] = s.peek();
                s.push(nums[i]);
            }
        }

        // Printing Next smaller elements
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]+" ---> "+NSE[i]);
    }
    public static void main(String[] args) {
        int[] nums = {12,3,46,7,4,8,5};
        findNSE(nums);
    }
}
