public class Circular_linkedList {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
        }
    }
    public Node push(int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        new_node.next = head;
        if(head != null)
        {
            while(current.next != head)
                current = current.next;
            current.next = new_node;
        }
        else
            new_node.next = new_node;
        head = new_node;
        return head;
    }

    public void print_list()
    {
        Node current = head;
        if(head == null)
            System.out.println("List is empty . ");
        else
        {
            do{
                System.out.print(current.data+" ");
                current = current.next;
            }while(current != head);
        }
        System.out.println();
            }
    public static void main(String[] args)
    {
        Circular_linkedList list = new Circular_linkedList();
        list.print_list();
        list.push(4);
        list.push(5);
        list.push(8);
        list.push(19);
        list.print_list();
    }
}
