package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class StackSortingUsingRecursion {
    static void sortedInsert(Stack<Integer> s , int x)
    {
        if(s.isEmpty() || x>s.peek()) {
            s.push(x);
            return;
        }

        int GreaterElementThanX = s.pop();
        sortedInsert(s,x);
        s.push(GreaterElementThanX);
    }
    static void sortStack(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        int x = s.pop();
        sortStack(s);
        sortedInsert(s,x);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values in Stack : ");
        int choice = 1;
        while(choice == 1) {
            System.out.print("Enter value : ");
            int n = sc.nextInt();
            s.push(n);
            System.out.print("Press 1 to continue : ");
            choice = sc.nextInt();
        }
        System.out.println("Input Stack : "+s);
        sortStack(s);
        System.out.println("Sorted Stack : "+s);
    }
}
