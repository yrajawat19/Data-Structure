package Stacks;

public class Stack_as_linkedlist
{
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void Push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void Pop()
    {
        if(head == null)
        {
            System.out.println("Stacks.Stack underflow !!");
        }
        Node temp;
        System.out.println(head.data+" Popped .");
        temp = head.next;
        head = temp;

    }

    public void Traverse()
    {
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Stack_as_linkedlist stack = new Stack_as_linkedlist();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Traverse();
        stack.Pop();
        stack.Traverse();
    }
}
