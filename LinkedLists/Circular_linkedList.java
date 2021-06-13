/* Java Program to perform basic operations Insertion , deletion and updation of circular linked list */
public class Circular_linkedList {
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d ;
        }
    }
    /* Function to insert an element at front of circular linked list . */
    /* We need to change last nodes pointing address to new inserted node as it is head now */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        if(head == null)
        {
            head = new_node;
            new_node.next = head;
        }
        else
        {
            while(current.next != head)
            {
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
            head = new_node;
            return;
        }

    }

    /* Function to insert element at last of circular linked list */
    public void append(int new_data)
    {
        Node current = head;
        Node new_node = new Node(new_data);
        if(head == null)
        {
            head = new_node;
            new_node.next = head;
        }
        else
        {
            while(current.next != head)
            {
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
        }
    }

    /* Function to insert an element before given key */
    /* Cases we need to take care of when inserting a node before given key node
    * 1. when given node is head of CLL
    * 2. when given node does not exist in CLL
    * 3. when given node is tail of CLL
    * 4. when given node is in between of CLL  */
    public void insertBefore(int key , int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        Node previous = null;
        while(current.data != key)
        {
            if(current.next == head && current.data != key)
            {
                System.out.println("Given node does not exist in CLL . ");
                return;
            }
            previous = current;
            current = current.next;

        }
        if(head == current)
        {
            previous = head;
            while(previous.next!= head)
            {
                previous = previous.next;
            }
            previous.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {
            previous.next = new_node;
            new_node.next = current;
            return;
        }
    }

    /* Function to insert an element after a given key */
    public void insertAfter(int key, int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        while(current.data != key)
        {
            if(current.next == head)
            {
                System.out.println("Given node does not exist in CLL . ");
                return;
            }
            current = current.next;
        }
        new_node.next = current.next;
        current.next = new_node;
    }
    /* Function to update the node */
    public void updateNode(int key, int new_data)
    {
        Node current = head;
        while(current.data != key)
        {
            if(current.next == head && current.data != key)
            {
                System.out.println("Given node to update does not exist . ");
                return;
            }
            current = current.next;
        }
        current.data = new_data;
        return;
    }

    /* Function to perform deletion on circular linked list */
    /* Cases we need to take care of when performing deletion
    * 1. when CLL is empty
    * 2. when deleting node is head of CLL
    * 3. when deleting node is tail of CLL
    * 4. when deleting node is in between of CLL
    * 5. when deleting node is single node in CLL */

    public void deleteNode(int key)
    {
        Node current = head;
        Node previous = null;
        /* Condition to check if linked list is empty or not*/
        if(head == null)
        {
         System.out.println("CLL is empty.");
         return;
        }
        while(current.data != key)
        {
            previous = current;
            current = current.next;
            /* Condition to run when given node does not exist */
            if(current.next == head && current.data != key)
            {
                System.out.println("Deleting node does not exist in CLL .");
                return;
            }
        }
        if(previous == null && current.data == key)
        {
            head = null;
            return;
        }
        if(current == head)
        {
            previous = head;
            while(previous.next != head)
            {
                previous = previous.next;
            }
            head = current.next;
            previous.next = head;
        }
        else
        {
            previous.next = current.next;
        }
        return;
    }

    /* Function to reverse the circular linked list */
    public void reverseList()
    {
        Node current = head;
        Node next = null;
        Node previous = null;
        if(head == null)
            return;
        do
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }while(current != head);
        head.next = previous;
        head = previous;
        return;
    }

    /* Function to traverse the linked list */
    public void display()
    {
        Node current = head;
        if(head == null)
            System.out.println("Circular linked list is empty . ");
        else
        {
            do{
                System.out.print(current.data+" ");
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }


    public static void main(String[] args)
    {
        Circular_linkedList CLL = new Circular_linkedList();
        CLL.push(78);
        CLL.push(342);
        CLL.push(244);
        CLL.push(545);
        System.out.println("Circular linked list after push operation . ");
        CLL.display();
        CLL.append(23);
        CLL.append(79);
        CLL.append(11);
        System.out.println("Circular linked list after append operation . ");
        CLL.display();
        System.out.println("circular linked list after insertBefore Operation . ");
        CLL.insertBefore(545,90);
        CLL.display();
        System.out.println("circular linked list after insertAfter Operation . ");
        CLL.insertAfter(90,654);
        CLL.display();
        System.out.println("Circular linked list after delete operation .");
        CLL.deleteNode(78);
        CLL.display();
        System.out.println("After updation operation .");
        CLL.updateNode(11,99);
        CLL.display();
        System.out.println("After reversing the CLL . ");
        CLL.reverseList();
        CLL.display();
    }
}