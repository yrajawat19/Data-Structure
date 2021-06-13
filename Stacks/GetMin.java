/* Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
Your task is to complete all the functions, using stack data-Structure.*/
package Stacks;
import java.util.*;
public class GetMin {
    Stack<Integer> stack = new Stack();
    int min;
    // Function to push elements in stack .
    public void insert(int key)
    {
        if(stack.empty()) {
            min = key;
            stack.push(key);
            System.out.println(key+" pushed in stack .");
            return;
        }
        else if(key<min)
        {
            stack.push(2*key - min);
            min = key;
            System.out.println(key+" pushed in stack .");
        }
        else {
            stack.push(key);
            System.out.println(key+" pushed .");
        }
    }
    // Function to pop element from stack .
    public void delete()
    {
        if(stack.empty()) {
            System.out.println("Stack is empty . ");
            return;
        }

        int top = stack.peek();
        if(top < min)
        {
            min = 2*min - top;
            stack.pop();
            System.out.println(min+" popped .");
        }
        else {
            stack.pop();
            System.out.println(top+" popped . ");
        }
    }

    public void getMin()
    {
        System.out.println("Minimum element in stack : " +min);
    }
    public static void main(String[] args) {
            GetMin s = new GetMin();
            s.insert(7);
            s.insert(3);
            s.getMin();
            s.insert(4);
            s.insert(5);
            s.insert(1);
            s.getMin();
            s.insert(2);
            s.delete();
            s.delete();
            s.delete();
            s.delete();
            s.getMin();

    }
}
