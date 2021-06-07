/* an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
Input: the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f*/
package LinearDS;
public class Delete_Middle_element {
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void push(int new_data) // Push function insert element at front of linked list
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        return;
    }
    public void printlist(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
        public void removeMiddle(Node node){
            if(node == null || node.next == null)
                return;
            node.data = node.next.data;
            node.next = node.next.next;
        }
    public static void main(String[] args) {
        Delete_Middle_element list = new Delete_Middle_element();
        list.push(3);
        list.push(5);
        list.push(7);
        list.push(9);
        list.push(2);
        list.printlist(list.head);
        list.removeMiddle(list.head.next.next);
        list.printlist(list.head);
    }
}
