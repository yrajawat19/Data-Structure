public class length_of_linkedList {
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
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void print_list()
    {
        Node n= head;
        while(n!=null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    public void length()
    {
        Node n = head;
        int count = 0;
        while(n!=null)
        {
            count++;
            n = n.next;
        }
        System.out.print("Elements in list "+count);
    }
    public static void main(String[] args)
    {
        length_of_linkedList llist = new length_of_linkedList();
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.print_list();
        llist.length();
    }
}
