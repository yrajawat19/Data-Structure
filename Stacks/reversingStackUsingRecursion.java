package Stacks;

import java.util.Stack;

public class reversingStackUsingRecursion {
    static Stack<Integer> stack = new Stack<>();
    public static void insert_at_bottom(int element)
    {
        if(stack.isEmpty())
            stack.push(element);
        else
        {
            int a = stack.pop();
            insert_at_bottom(element);
            stack.push(a);
        }
    }
    public static void reverse()
    {
        if(stack.size() >0 ) {
            int element = stack.pop();
            reverse();
            insert_at_bottom(element);
        }
    }
    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse();
        System.out.println(stack);
    }
}
