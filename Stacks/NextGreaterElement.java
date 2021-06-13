package Stacks;

import java.util.Stack;

public class NextGreaterElement {
    public static void findNGE(int[] nums)
    {
        Stack<Integer> s = new Stack<>(); // Stack
        int[] NGE = new int[nums.length]; // NGE array
        for(int i=nums.length-1;i>=0;i--) // Reverse traversing the nums array
        {
            if(!s.empty())  // when stack is not empty
                while(!s.empty() && s.peek() <= nums[i]) // pop element from stack until stack top element is smaller than nums element at index i.
                    s.pop(); // pop an element .
            if(s.empty()) // If stack is empty it means there is no greater element to the right side of element .
                NGE[i] = -1; // hence store  -1 in NGE array
            else
                NGE[i] = s.peek(); // Else stack's top element is next greater element .
            s.push(nums[i]); // push the element in stack .
        }
        // Printing next greater elements
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i] +" --- > "+NGE[i]);
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,6,4,13,12,10,24};
        findNGE(nums);
    }
}
