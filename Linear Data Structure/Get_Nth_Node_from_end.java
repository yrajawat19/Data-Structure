/* ************************** Program for the Nth node from the end of linked list ************************** */
public class Get_Nth_Node_from_end {
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
    public void printlist()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public void Get_Nth_from_end(int n)
    {
        int len = 0;
        Node current = head;
        while(current != null)
        {
            current = current.next;
            len++;
        }
        if(len<n)
        {
            System.out.println("Given index is out of range .");
            return;
        }
        current = head;
        for(int i=1;i<(len-n)+1;i++)
        {
            current = current.next;
        }
        System.out.println("Element at index "+n+" from end is "+current.data);
        return;
    }

    public void Get_Nth_node(int n)
    {
        Node current = head;
        int index =1;
        while(current != null)
        {
            if(index == n)
            {
                System.out.print("The element in index "+n+" is "+current.data);
            }
            index++;
            current = current.next;

        }

        return;
    }
    public static void main(String[] args)
    {
        Get_Nth_Node_from_end list = new Get_Nth_Node_from_end();
        list.append(4);
        list.append(5);
        list.append(6);
        list.push(24);
        list.push(8);
        list.printlist();
        list.Get_Nth_from_end(2);
        list.Get_Nth_node(2);
    }
}
