import org.jetbrains.annotations.NotNull;

/* ************************************** Doubly linked list ************************************* */
/* Operations performed on double linked list
* 1) Insertion - At front , At end , in between in double linked list
* 2) Deletion  - At front , At end , in between in double linked list
* 3) Traversal  - Forward and Backward traversal of linked list */
public class Doubly_Linkedlist {
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int d)
        {
            data = d;
        }
    }
    /* Push function insert element at front of double linked list */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if(head != null)
            head.prev = new_node;
        head = new_node;
        System.out.println(new_node.data + " pushed . ");
        return;
    }

    /* InsertAfter takes two arguments prev node and data value and insert the element after given prev node*/
    public void InsertAfter(Node prev_node,int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        new_node.prev = prev_node;
        prev_node.next = new_node;
        if(new_node.next != null)
        {
            new_node.next.prev = new_node;
        }
        System.out.println(new_node.data + " inserted after "+prev_node.data);
        return;
    }

    /* InsertBefore function insert element before given Node */
    public void InsertBefore( Node next_node, int new_data)
    {
        Node new_node = new Node(new_data);
        if(next_node.prev == null) {
            new_node.prev = null;
            head = new_node;
        }
        else {
            new_node.prev = next_node.prev;
        }
        next_node.prev = new_node;
        new_node.next = next_node;
        if(new_node.prev != null)
        {new_node.prev.next = new_node;}
        System.out.println(new_node.data+ " inserted before "+next_node.data);
        return;
    }

    /* Insert element at the end of the double linked list */
    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new_node;
        new_node.next = null;
        new_node.prev = current;
        System.out.println(new_node.data+ " appended in the list .");
        return;
    }

    public void deleteNode(int key)
    {
        Node current = head;
        if(current == null)
        {
            System.out.println("List is empty !! nothing to delete.");
            return;
        }
        while(current.data != key)
        {
            if(current.next == null)
                System.out.println("Element not found");
            current = current.next;
            break;
        }
        if(current == head)
        {
            head = null;
            return;
        }
        if(current.data == key && current == head)
        {
            head = current.next;
            current.next.prev = null;

        }
        else if(current.next == null)
            current.prev.next = null;
        else
        {
            current.prev.next = current.next;
            current.next.prev= current.prev;
        }
        System.out.println(key+" Deleted .");
        return;
    }

    /* Forward traversal of double linked list */
    public void Forward_traversal()
    {
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();

    }

    /* Backward traversal of double linked list */
    public void Backward_traversal()
    {
        Node current =  head;
        while( current.next != null)
        {current = current.next;}
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Doubly_Linkedlist list = new Doubly_Linkedlist();
        list.push(10);  // After push operation , Linked list : 10
        list.push(20);  // After push operation , Linked list : 20 10
        list.push(30);  // After push operation , Linked list : 30 20 10
        list.push(40);  // After push operation , Linked list : 40 30 20 10
        list.push(50);  // After push operation , Linked list : 50 40 30 20 10
        list.push(60);  // After push operation , Linked list : 60 50 40 30 20 10
        list.Forward_traversal();   // Forward Traversal : 60 50 40 30 20 10
        list.Backward_traversal();  // Backward Traversal : 10 20 30 40 50 60
        list.InsertAfter(list.head, 90); //Inserted after 60
        list.Forward_traversal();   // Forward Traversal : 60 90 50 40 30 20 10
        list.Backward_traversal();  // Backward Traversal : 10 20 30 40 50 90 60
        list.InsertBefore(list.head, 85); // Inserted before 60
        list.Forward_traversal();   // Forward Traversal : 85 60 90 50 40 30 20 10
        list.Backward_traversal();  // Backward Traversal : 10 20 30 40 50 90 60 85
        list.append(35);    // Appended 35 in end of the list
        list.Forward_traversal();   // Forward Traversal : 85 60 90 50 40 30 20 10 35
        list.Backward_traversal(); // Backward Traversal : 35 10 20 30 40 50 90 60 85
        list.deleteNode(35);    // 35 deleted
        list.Forward_traversal();   // Forward Traversal 85 60 90 50 40 30 20 10
        list.Backward_traversal();  // Backward Traversal 10 20 30 40 50 90 60 85
    }
    }
