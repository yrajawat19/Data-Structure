package LinearDS;

import java.util.*;

public class InterSection_of_LL
{
    Node root;
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    // Method to add node before given node.
    public void addBefore(int key , int data)
    {
        Node new_node = new Node(data);
        Node current = root;
        Node prev = null;
        if(root.data == key)
        {
            new_node.next = root;
            root = new_node;
            return;
        }
        while(current.data != key)
        {
            prev = current;
            current = current.next;
        }
        new_node.next = prev.next;
        prev.next = new_node;
    }
    // method to add node at front of LinkedList.
    public void push(int data)
    {
        Node new_node = new Node(data);
        if(root == null)
            root = new_node;
        new_node.next = root;
        root = new_node;
    }
    // Method to add element at back of linked list .
    public void append(int data)
    {
        Node new_node = new Node(data);
        if(root == null)
            root = new_node;
        Node current = root;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new_node;
        new_node.next = null;
    }
    // Method to print Linked list .
    public void printLL()
    {
        Node current = root;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
     static ArrayList<Integer> Intersection(Node ll1 , Node ll2)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Node curr1 = ll1;
        Node curr2 = ll2;
        while(curr1 != null)
        {
            map.put(curr1.data,1);
            curr1 = curr1.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(curr2 != null)
        {
            if(map.containsKey(curr2.data))
                    list.add(curr2.data);
        }
        return list;
    }
    public static void main(String[] args) {
        InterSection_of_LL ll1 = new InterSection_of_LL();
        InterSection_of_LL ll2 = new InterSection_of_LL();
        ll1.append(23);
        ll1.append(87);
        ll1.append(45);
        ll1.append(32);
        ll1.append(69);
        ll2.append(28);
        ll2.append(23);
        ll2.append(76);
        ll2.append(69);
        ll2.append(12);
        System.out.println("Linked list 1 :");
        ll1.printLL();
        System.out.println("Linked list 2 : ");
        ll2.printLL();
        ArrayList<Integer> list = Intersection(ll1.root,ll2.root);
        for(int i:list)
            System.out.println(i+" ");

    }
}