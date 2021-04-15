/* ******************************************** Deleting a link list *******************************************/
public class Deleting_a_LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void append (int new_data)
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
    public void print_list()
    {
        Node n = head;

        while(n != null)
        {
            System.out.print(n.data+" ");
            return;
        }
        System.out.println();

    }

    public void delete_list()
    {
        head = null;
        System.out.println("List Deleted ");
    }
    public static void main(String[] args)
    {
        Deleting_a_LinkedList llist = new Deleting_a_LinkedList();
        llist.append(9);
        llist.append(8);
        llist.append(9);
        llist.append(10);

        llist.print_list();
    }
}
