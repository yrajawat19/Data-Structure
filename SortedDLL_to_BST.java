/* Java Program for In-place conversion of Doubly linked list to balanced BST . */
/* Given a Doubly Linked List which has data members sorted in ascending order.
 Construct a Balanced Binary Search Tree which has same data members as the given Doubly Linked List.
The tree must be constructed in-place (No new node should be allocated for tree conversion)*/
/* In this method, we construct from leaves to root.
The idea is to insert nodes in BST in the same order as the appear in Doubly Linked List,
so that the tree can be constructed in O(n) time complexity.
We first count the number of nodes in the given Linked List.
Let the count be n. After counting nodes, we take left n/2 nodes
and recursively construct the left subtree. After left subtree is constructed,
we assign middle node to root and link the left subtree with root.
Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next
so that we have the appropriate pointer in each recursive call.
Following is the implementation of method 2. The main code which creates Balanced BST is highlighted.*/
public class SortedDLL_to_BST
{
    Node head;
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int d)
        {
            data = d;
            next = null;
            prev = null;
        }
    }

    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if(head == null)
        {
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new_node;
        new_node.prev = current;
    }
    public void printList()
    {
        Node current = head;
        while(current!= null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public Node sortedDLL_TO_BST()
    {
        int n = countNodes(head);
        return sortedDLL_TO_BSTREC(n);
    }
    public int countNodes(Node head)
    {
        Node current = head;
        int count = 0;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }
    public Node sortedDLL_TO_BSTREC(int n)
    {

        if(n<=0)
            return null;
        Node left = sortedDLL_TO_BSTREC(n/2);
        Node root = head;
        root.prev= left;
        head = head.next;
        root.next = sortedDLL_TO_BSTREC(n-n/2-1);
        return root;
    }

    public void inorder(Node node)
    {
        if(node != null) {
            inorder(node.prev);
            System.out.print(node.data + " ");
            inorder(node.next);
        }
    }

    public void preorder(Node node)
    {
        if(node != null)
        {
            preorder(node.prev);
            preorder(node.next);
            System.out.print(node.data+" ");

        }
    }

    public static void main(String[] args)
    {
        SortedDLL_to_BST list = new SortedDLL_to_BST();
        int values[] = {10,20,30,40,50,60,70,80,90};
        for(int i:values)
            list.append(i);
        System.out.println("Data members in DLL :");
        list.printList();
        Node root = list.sortedDLL_TO_BST();
        System.out.println("Data memebers in BST :");
        list.inorder(root);
        System.out.println();
        list.preorder(root);
        System.out.println();
    }
}