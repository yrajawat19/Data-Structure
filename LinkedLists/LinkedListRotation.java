package LinkedLists;

public class LinkedListRotation {
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
    
    // Function to right rotate the linked list .
    public void rotateRight(int k) {
        if (head != null) {
            Node fast = head;
            Node slow = head;

            int size = 1;

            while (fast.next != null) {
                size++;
                fast = fast.next;
            }

            for (int j = size - k % size; j > 1; j--) {
                slow = slow.next;
            }

            fast.next = head;
            head = slow.next;
            slow.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListRotation ll = new LinkedListRotation();
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);
        ll.print();
        ll.rotateRight(2);
        ll.print();
        
    }
}
