public class Get_the_Nth_Node {
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

    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head= new_node;
    }

    public void append(int new_data)
    {
        Node last = head;
        Node new_node = new Node(new_data);
        new_node.next = null;
        if(head == null)
        {
            head = new Node(new_data);
            return;
        }
        while(last.next!=null)
        {
            last = last.next;
        }
        last.next = new_node;
        return;
    }

    public void delete_at_front()
    {
        if(head==null)
        {
            System.out.print("List is empty !! ");
            return;
        }
        Node temp = head;
        head = temp.next;
        System.out.println(temp.data+" Deleted .");
    }

    public void delete_at_end()
    {
        if(head == null)
        {
            System.out.println("List is empty !!");
            return;
        }

        Node current = head;
        Node prev = null;
        while(current.next != null)
        {
            prev = current;
            current = current.next;

        }
        System.out.println(current.data +" Deleted.");
        prev.next = null;
        current = prev.next;
    }

    public void print_list()
    {
        Node n = head;
        while(n!=null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public void GetNth(int index)
    {
        Node current = head;
        int count = 0;
        while(current != null)
        {
            if(count == index)
                System.out.println("The element at index "+index+" is "+current.data);
            count++;
            current = current.next;
        }
    }
    public static void main(String[] args)
    {
        Get_the_Nth_Node list = new Get_the_Nth_Node();
        list.push(7);
        list.push(8);
        list.push(9);
        list.append(10);
        list.print_list();
        list.GetNth(2);
        list.delete_at_front();
        list.delete_at_end();
        list.print_list();
    }
}
