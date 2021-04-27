/* A simple inorder traversal based java program to find Kth smallest number in Binary search tree .*/
import java.io.*;
import java.util.Scanner;

class BSTree{
    Node root;
    Node result;
    class Node{
        int key;
        Node left;
        Node right;
        int lcount;
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
            lcount = 0;
        }
    }
    BSTree()
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
        if(key<root.key)
        {
            root.left = insertRec(root.left,key);
            root.lcount++;
        }
        else if(key>root.key)
            root.right = insertRec(root.right,key);
        return root;
    }

    public void inorder()
    {
        inorderRec(root);
    }

    public void inorderRec(Node root)
    {
        if(root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key+" ");
            inorderRec(root.right);
        }
    }

    public Node findKth(Node root,int k)
    {
        if(root == null)
            return null;
        if(k== root.lcount+1)
            return root;
        if(k<root.lcount+1)
            return findKth(root.left,k);

        return findKth(root.right,k-(root.lcount+1));
    }

}

public class KthSmallest_in_BST {
    public static void main(String[] args)
    {
        BSTree tree = new BSTree();
        int k;
        Scanner sc = new Scanner(System.in);
        int keys[] = {20,50,40,30,80,90,100,180,45,65,75,12,35,95,85,145};
        for(int i :keys)
            tree.insert(i);
        tree.inorder();
        System.out.println();
        System.out.println("Enter the Kth value to search Kth smallest value in BST :");
        k = sc.nextInt();
         tree.result = tree.findKth(tree.root,k);
         if(tree.result!=null)
             System.out.println("The "+k+"th smallest value in BST is "+tree.result.key);
         else
             System.out.println("No smallest value found");



    }
}
