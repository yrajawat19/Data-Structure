/* Java program to detect loop in linked list */
import java.util.*;
class Linkedlist
{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        if(head == null)
        {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
        return;
    }

    public void traverse()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
        return;
    }
    public boolean detectLoop()
    {
        Node current = head;
        HashSet<Node> s = new HashSet<Node>();
        while(current != null) {
            if (s.contains(current)) {
                System.out.println("Loop exists at " + current.data);

                return true;
            }
            s.add(current);
            current = current.next;

        }
        System.out.println("Loop does not exist .");
        return false;
    }
}
public class Detect_a_loop_in_linkedList {

    public static void main(String[] args)
    {
        Linkedlist llist = new Linkedlist();
        llist.push(70);
        llist.push(29);
        llist.push(34);
        llist.push(89);
        llist.traverse();
        llist.detectLoop();
        llist.head.next.next.next = llist.head;
        llist.detectLoop();

    }
}
