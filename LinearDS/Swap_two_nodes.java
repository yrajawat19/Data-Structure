/* Java Program to swap nodes in linked list without swapping data*/
/* Given a linked list and two keys in it, swap nodes for two given keys.
 Nodes should be swapped by changing links.  Swapping data of nodes may be expensive
 in many situations when data contains many fields. */
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
class linked_list
{
    Node head ;
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        if(head == null)
        {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
        return;
    }

    public void traverse()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }

    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        Node current = head;
        if(head == null)
        {
            head = new_node;
            return;
        }
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new_node;
        return;
    }

    public void swapNodes(int x,int y)
    {
        // Check whether x and y are same
        if(x==y)
        {
            System.out.println("Both nodes can't be same .");
            return;
        }
        // look for X in linked list
        Node currX = head;
        Node prevX = null;
        while (currX.data != x && currX.next != null)
        {
            prevX = currX;
            currX = currX.next;
        }
        // look for Y in linked list
        Node currY = head;
        Node prevY = null;
        while (currY.data != y && currY.next != null)
        {
            prevY = currY;
            currY = currY.next;
        }

        // If any of X and Y is not present in linked list
        if(currX == null || currY == null)
        {
            System.out.println("Either element is not present in linked list.");
            return;
        }

        // If X is not head of list
        if(prevX != null)
            prevX.next = currY;
        else
            head = currY;
        // If Y is not head of list
        if(prevY != null)
            prevY.next = currX;
        else
            head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
}

public class Swap_two_nodes {
    public static void main(String[] args)
    {
        linked_list list = new linked_list();
        for(int i=1;i<=10;i++)
        {
            list.append(i);
        }
        list.traverse();
        list.swapNodes(3,7);
        list.traverse();
    }
}
