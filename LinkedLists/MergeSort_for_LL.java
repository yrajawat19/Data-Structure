package LinkedLists;
class LinkedList
{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    public void append(int data)
    {
        Node new_node = new Node(data);
        if(head == null) {
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new_node;
    }
    public void printLL(Node head)
    {
        Node current = head;
        if(current == null)
            return;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node middle = getMiddle(head);
        Node NextOfMiddle = middle.next;

        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(NextOfMiddle);
        Node sortedLL = sortedMerge(left,right);
        return sortedLL;
    }
    Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next,b);
        }
        else {
            result = b;
            result.next = sortedMerge(a,b.next);
        }
        return result;
    }
    static Node getMiddle(Node head) {
        if(head == null)
            return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
public class MergeSort_for_LL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(65);
        ll.append(12);
        ll.append(43);
        ll.append(98);
        ll.append(2);
        System.out.println("List before sorting :");
        ll.printLL(ll.head);
        System.out.println("List after sorting : ");
        ll.mergeSort(ll.head);
        ll.printLL(ll.head);
    }
}
