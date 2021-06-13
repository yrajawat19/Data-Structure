package LinkedLists;

public class Split_the_CLL {
    Node head;
    Node head1;
    Node head2;
    class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    public void append(int data)
    {
        Node new_node = new Node(data);
        if(head == null)
        {
            head = new_node;
            new_node.next = head;
            return;
        }
        Node current = head;
        while(current.next != head)
        {
            current = current.next;
        }
        current.next = new_node;
        new_node.next = head;
    }
    public void printLL(Node head)
    {
        if(head != null) {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }
    public void splitLL()
    {
        if(head == null)
            return;
        Node slow = head;
        Node fast = head;
        while(fast.next != head && fast.next.next != head)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next.next == head)
            fast = fast.next;

        head1 = head;
        if(head.next != head)
            head2 = slow.next;
        fast.next = slow.next;
        slow.next = head;
    }
    public static void main(String[] args) {
        Split_the_CLL ll = new Split_the_CLL();
        ll.append(2);
        ll.append(3);
        ll.append(7);
        ll.append(9);
        ll.append(5);
        ll.append(4);
        ll.printLL(ll.head);
        ll.splitLL();
        System.out.println("List 1 after splitting : ");
        ll.printLL(ll.head1);
        System.out.println("List 2 after splitting : ");
        ll.printLL(ll.head2);
    }
}
