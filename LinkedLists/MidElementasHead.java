package LinkedLists;

public class MidElementasHead {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    void push(int data)
    {
        Node new_node = new Node(data);
        if(head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;

    }
    void midElementasHead()
    {
        if(head != null) {
            Node fast = head;
            Node slow = head;
            Node prev = null;
            while(slow != null && fast.next != null)
            {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = slow.next;
            slow.next = head;
            head = slow;
        }

    }
    void printLL()
    {
        if(head != null) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MidElementasHead list = new MidElementasHead();
        list.push(4);
        list.push(8);
        list.push(6);
        list.push(9);
        list.push(5);
        list.push(7);
        list.push(3);
        list.push(2);
        list.push(10);
        list.push(11);
        list.push(56);
        list.printLL();
        list.midElementasHead();
        list.printLL();
    }
}
