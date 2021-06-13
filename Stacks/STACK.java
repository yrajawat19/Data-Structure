package Stacks;

class stack1{
    int size = 10;
    int stack[] = new int[size];
    int top = -1;

    void push(int item) {
        if (top < size-1) {
            top++;
            stack[top] = item;
            System.out.println("Item pushed:" + item);
        } else {
            System.out.println("Stacks.Stack is overflowing!!");
        }
    }

    void pop() {
        if (top >= 0) {
            int item = stack[top];
            top--;
            System.out.println("Item Popped:" + item);
        } else {
            System.out.println("Stacks.Stack is Underflowing");
        }
    }

    void show() {
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
    }
}
public class STACK {
    public static void main(String args[]) {
        stack1 s = new stack1();
        s.push(99);
        s.push(88);
        s.push(77);
        s.push(66);
        s.push(55);
        s.push(44);
        s.push(33);
        s.push(22);
        s.push(11);
        s.push(101);
        s.push(111);
        s.show();
        s.pop();
        s.show();
    }
}
