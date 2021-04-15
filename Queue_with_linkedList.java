public class Queue_with_linkedList {
    // Linkedlist Node
    Node head;
   public class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    // Function to add elements in end of Queue
    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if(head == null)
        {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while(last.next!=null)
        {
            last = last.next;
        }
        last.next = new_node;
        return;
    }
    // Function to traverse the Queue
    public void show_list()
    {
        Node n = head;
        while (n!=null)
        {
            System.out.print(n.data +" ");
            n = n.next;
        }
        System.out.println();
    }
    // Function to delete the element at front
    public void delete()
    {
        if( head == null)
            return ;
        Node deleting_node = head.next;
        head = deleting_node;

    }
    public static void main(String[] args)
    {
        Queue_with_linkedList list = new Queue_with_linkedList();
        list.append(9);
        list.append(8);
        list.append(7);
        list.append(6);
        list.append(798);
        list.show_list();
        list.delete();
        list.show_list();
    }
}