/* Java Program to remove duplicates from unsorted list */
package LinkedLists;
import java.util.HashSet;

public class RemoveDuplicates_from_SLL {
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
    public void remove_duplicates(Node head) {
            Node current = head;
            Node prev = null;
        HashSet<Integer> set = new HashSet<>();
            while(current != null)
            {
                if(set.contains(current.data))
                    prev.next = current.next;
                else {
                    set.add(current.data);
                    prev = current;
                }
                current = current.next;
            }
    }
    public static void main(String[] args) {
        RemoveDuplicates_from_SLL list = new RemoveDuplicates_from_SLL();
        list.push(2);
        list.push(4);
        list.push(2);
        list.push(1);
        list.push(2);
        list.push(7);
        list.push(9);
        list.push(4);
        list.push(2);
        list.printlist(list.head);
        list.remove_duplicates(list.head);
        list.printlist(list.head);

    }
}
