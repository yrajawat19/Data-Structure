/* Java program to reverse a linked list */
public class reverse_a_linkedList {
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d ;
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

    public Node reverseList()
    {
        Node previous = null;
        Node current = head;
        Node next = null;
        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
    public static void main(String[] args)
    {
        reverse_a_linkedList list = new reverse_a_linkedList();
        list.push(200);
        list.push(199);
        list.push(198);
        list.push(197);
        list.traverse();
        list.reverseList();
        list.traverse();

    }
}
