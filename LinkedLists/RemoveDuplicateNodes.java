package LinkedLists;

public class RemoveDuplicateNodes {
    Node head ;
    class Node {
        int data ;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    // Function to push elements in linked list .
    public void push(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    // Function to print linked list
    public void print() {
        if(head != null) {
            Node current = head ;
            while(current != null) {
                System.out.print(current.data+" ");
                current = current.next;
            }
        }
        System.out.println();
    }

     // Function to remove duplicate nodes from linked list .
    public void removeDuplicates(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast != null) {
            while(fast.next != null && fast.data == fast.next.data) {
                fast = fast.next ;
            }

            if(slow.next != fast)
            {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next ;
                fast = fast.next ;
            }
        }
    }
    public static void main(String[] args) {
        RemoveDuplicateNodes ll = new RemoveDuplicateNodes();
        ll.push(5);
        ll.push(4);
        ll.push(4);
        ll.push(3);
        ll.push(3);
        ll.push(2);
        ll.push(1);
        ll.print();
        ll.removeDuplicates(ll.head);
        ll.print();
    }
}
