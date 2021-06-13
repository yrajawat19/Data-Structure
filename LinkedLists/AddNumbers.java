package LinkedLists;

public class AddNumbers {
    Node head;
    static class Node
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
    public static void printlist(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public static Node addNumbers(Node first , Node second)
    {
        int carry = 0, sum = 0;
        Node result = null;
        Node prev = null;
        Node temp = null ;
        while(first != null || second != null)
        {
            if(first != null && second != null)
                sum = carry + first.data + second.data;
            else if(first == null)
                sum = carry + second.data;
            else if(second == null)
                sum = carry + first.data;
            if(sum > 9)
                carry = sum/10;
            else
                carry = 0;
            sum = sum % 10;
            temp = new Node(sum);
            if(result == null)
                result = temp;
            else
                prev.next = temp;

            prev = temp;
            if(first != null)
                first = first.next;
            if(second != null)
                second = second.next;
        }
        if(carry > 0)
            temp.next = new Node(carry);

        return result;
    }
    public static void main(String[] args) {
        AddNumbers Num1 = new AddNumbers();
        AddNumbers Num2 = new AddNumbers();
        /* Num1 : 376 and Num2 : 54 and sum will be 421 . Numbers are stored in reverse order . */
        Num1.push(3);
        Num1.push(7);
        Num1.push(6);
        Num2.push(4);
        Num2.push(5);
        System.out.println("Num1 in reverse order : ");
        Num1.printlist(Num1.head);
        System.out.println("Num2 in reverse order : ");
        Num2.printlist(Num2.head);
        Node result = addNumbers(Num1.head , Num2.head);
        System.out.println("Sum of Num1 and Num2 in reverse order : ");
        printlist(result);

    }
}
