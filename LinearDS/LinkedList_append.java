public class LinkedList_append {
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
    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if(head == null)
        {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head ;
        while(last.next!=null)
        {
            last = last.next;
        }
        last.next = new_node;
        return;
    }

    public void insertAfter(Node prev_node, int new_data)
    {
        if(prev_node == null)
        {
            System.out.println("The given previous node can not be null !!");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    public void printList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
    public static void main(String[] args)
    {
        LinkedList_append llist = new LinkedList_append();
        llist.append(2);
        llist.append(5);
        llist.append(8);
        llist.insertAfter(llist.head,86);
        llist.printList();

    }
}
