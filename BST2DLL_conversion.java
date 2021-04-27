/* Java Program to convert a Binary search tree to doubly linked list . */
/*  *************** PROBLEM STATEMENT ***********************************
Given a Binary search Tree (Bst), convert it to a Doubly Linked List(DLL).
The left and right pointers in nodes are to be used
as previous and next pointers respectively in converted DLL.
The order of nodes in DLL must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.*/
/*  *********************************** ALGORITHM FOR SOLUTION OF PROBLEM *********************************
1) If left subtree exists, process the left subtree
   i) Recursively convert the left subtree to DLL.
   ii) Then find inorder predecessor of root in left subtree (inorder predecessor is rightmost node in left subtree).
   iii) Make inorder predecessor as previous of root and root as next of inorder predecessor.
2) If right subtree exists, process the right subtree (Below 3 steps are similar to left subtree).
   i) Recursively convert the right subtree to DLL.
   ii) Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
   iii) Make inorder successor as next of root and root as previous of inorder successor.
3) Find the leftmost node and return it (the leftmost node is always head of converted DLL). */
class BinarySearch_Tree
{
    Node root;
    class Node{
        int key;
        Node left;
        Node right;
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }

    BinarySearch_Tree()
    {
        root = null;
    }

    public void insert(int key)
    {
        root = insertRec(root,key);
    }

    public Node insertRec(Node root, int key)
    {
        if(root == null)
        {
            root = new Node(key);
            return root;
        }
        if(root.key > key)
            root.left = insertRec(root.left,key);
        else if(root.key<key)
            root.right = insertRec(root.right,key);
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }
    public void preorder() {
        preorderRec(root);
    }
    public void inorderRec(Node root) {
        if(root != null)
        {
        inorderRec(root.left);
        System.out.print(root.key + " ");
        inorderRec(root.right);
    }
    }
    public void preorderRec(Node root) {
        if(root != null)
        {
            System.out.print(root.key+ " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    /* Method responsible for BST to DLL conversion .*/
    public Node BST2DLLRec(Node root)
    {
        if(root == null)
            return root;
        if(root.left != null)
        {
            Node left = BST2DLLRec(root.left);
            while(left.right != null)
                left = left.right;
            left.right = root;
            root.left = left;
        }
        if(root.right != null)
        {
            Node right = BST2DLLRec(root.right);
            while(right.left != null)
                right = right.left;
            right.left = root;
            root.right = right;
        }

        return root;
    }

    public Node BST2DLL(Node root)
    {
        if(root == null)
            return root;
        root = BST2DLLRec(root);
        while(root.left!=null)
            root = root.left;
        return root;
    }

    public void printList()
    {
        Node current = root;
        while(current != null)
        {
            System.out.print(current.key+" ");
            current = current.right;
        }
        System.out.println();
    }
}

public class BST2DLL_conversion {
    public static void main(String[] args) {
        BinarySearch_Tree tree = new BinarySearch_Tree();
        int keys[] = {12, 24, 36, 60, 48, 72, 96, 84, 120, 108, 132, 144, 168, 156};
        for (int i : keys)
            tree.insert(i);
        System.out.println("BST inorder traversal : ");
        tree.inorder();
        System.out.println();
        System.out.println("BST preorder traversal : ");
        tree.preorder();
        System.out.println();
        tree.BST2DLL(tree.root);
        System.out.println("DLL traversal : ");
        tree.printList();

    }
}
