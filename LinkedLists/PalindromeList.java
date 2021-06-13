package LinkedLists;

import java.util.Stack;

public class PalindromeList {
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void push(int new_data) // Push function insert element at front of linked list
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        return;
    }
    public void printlist(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isPalindrome(Node head)
    {
        Node slow = head;
        Node fast = head;
        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null)
        {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)
            slow = slow.next;
        while(slow != null)
        {
            int top = stack.pop().intValue();
            if(top != slow.data)
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeList list1 = new PalindromeList();
        PalindromeList list2 = new PalindromeList();
        list1.push(1);
        list1.push(2);
        list1.push(0);
        list1.push(2);
        list1.push(1);
        list2.push(1);
        list2.push(1);
        list2.push(2);
        list2.push(2);
        list2.push(0);
        list2.push(1);
        System.out.println("List 1 :");
        list1.printlist(list1.head);
        System.out.println("List 2 :");
        list2.printlist(list2.head);
        if(list1.isPalindrome(list1.head))
            System.out.println("Value in Linked list is Palindrome . ");
        else
            System.out.println("Value is not palindrome .");
        if(list2.isPalindrome(list2.head))
            System.out.println("Value in Linked list is Palindrome . ");
        else
            System.out.println("Value is not palindrome .");
    }
}
