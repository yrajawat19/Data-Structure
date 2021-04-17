/* ********************************** Linked List Program ********************************** */
public class LinkedList
{
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
    public void append(int new_data) //Append function insert element at end of linked list
    {
        Node new_node = new Node(new_data);
        Node current = head;
        if(head == null)
        {
            head = new_node;
            return;
        }

        while(current.next!=null)
        {
            current = current.next;
        }
        current.next = new_node;
        return;
    }

    public Node deleteNode(int key)  // deleteNode to remove an element from linked list
    {
        Node current = head;
        Node previous = null;
        // 1.List is empty
        if(head == null)
        {
            System.out.println("List is empty");
            return head;
        }
        while(current.data != key)
        {
            // Element is not found
            if(current == null)
            {
                System.out.println("Element not found");
                break;
            }
            previous = current;
            current = current.next;
        }
        // 2.Single element in List
        if(current == head && current.next == null)
        {
            head = null;
            return head;
        }
        // 3.first node of List
        if(current == head)
        {
            head = current.next;
        }
        // 4.last node of List
        else if(current.next == null)
        {
            previous.next = null;
        }
        // 5. somewhere in list
        else {
            previous.next = current.next;
        }
        return head;
    }
    public void printlist()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main (String[] args) {
        LinkedList list = new LinkedList();
        list.push(5);      // Linked list : 5
        list.append(7);             // Linked list : 5 7
        list.append(8);             // Linked list : 5 7 8
        list.append(9);             // Linked list : 5 7 8 9
        list.push(10);      // Linked list : 10 5 7 8 9
        list.printlist();            // List Traversal
        list.deleteNode(5);       // Node deleted : 5 . Linked List : 10 7 8 9
        list.printlist();
        list.deleteNode(10);         // Node deleted : 10 . Linked List : 7 8 9
        list.printlist();
        list.deleteNode(7);         // Node deleted : 7 . Linked List : 8 9
        list.printlist();
        list.deleteNode(9);           // Node deleted : 9 . Linked List : 8
        list.printlist();
        list.deleteNode(8);             // Node deleted : 8 . Linked List : null
        list.printlist();
        list.deleteNode(10);            // Not found condition
        list.printlist();
    }
}