/*  *********************************** Circular Linked list Program ******************************** */
public class Circular_linkedList
{
    Node head;
    /* Class Node defining blueprint of Node . Node class contains Two elements Integer type and Pointer to next Node */
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = head;
        }
    }
    /* Function to add element at front in circular linked list */
    public Node push(int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        if(head != null) {
            while (current.next != head)
                current = current.next;
            current.next = new_node;
        }
        else
            new_node.next = new_node;
        head = new_node;
        return head;
    }
    /* Function responsible for traversal of circular linked list */
    public void traverse()
    {
        Node current = head;
        if(head == null)
            System.out.println("Circular linked list is empty .");
        else
        {
            do{
                System.out.print(current.data+" ");
                current = current.next;
            }while(current != head);
        }
    }

    /* Function responsible for deletion of given element in circular linked list */
    public Node deleteNode(int key)
    {
        if(head == null)
        {
            System.out.println("List is empty !! nothing to delete .");
            return null;
        }
        Node current = head;
        Node previous = null;
        while( current.data != key)
        {
            if( current.next == head){
                System.out.println("Element is not found "+key);
                break; }
            previous = current;
            current = current.next;
        }
        // Condition if there is a single node in list and key matches with that node
        if(current == head && current.next == head )
        {
            head = null;
            return head;

        }
        // Condition if key matches with first node
        if(current == head)
        {
            previous = head;
            while (previous.next != head)
                previous = previous.next;
            head = current.next;
            previous.next = head;
        }
        // Condition if key matches with last node
        else if(current.next == head)
        {
            previous.next = head;
        }
        // Condition if key matches with node in between of list
        else {
            previous.next = current.next;
        }

        return head;
    }

    public static void main(String[] args)
    {
        Circular_linkedList list = new Circular_linkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.traverse();
        list.deleteNode(6);
        list.deleteNode(5);
        list.traverse();
    }
}