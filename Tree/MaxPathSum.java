package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {
    Node root;
    class Res {
        int val;
    }
    class Node
    {
        int key;
        Node left;
        Node right;
        Node (int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    public void insert(int key)
    {
        if(root == null)
        {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node temp = q.peek();
            q.remove();

            if(temp.left == null)
            {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
            if (temp.right == null)
            {
                temp.right = new Node(key);
                break;
            }
            else
            {
                q.add(temp.right);
            }
        }
    }

    public void inorder(Node temp)
    {
        if(temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }

    public int FindMaxPath(Node root) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        findMaxUtil(root,res);
        return res.val;
    }
    public int findMaxUtil(Node root, Res res)
    {
        if(root == null)
            return 0;
        int l = findMaxUtil(root.left,res);
        int r = findMaxUtil(root.right,res);

        int max_single = Math.max(Math.max(l,r)+root.key,root.key);
        int max_top = Math.max(max_single,l+r+root.key);
        res.val = Math.max(max_top,res.val);

        return max_single;
    }

    public static void main(String[] args) {
        MaxPathSum Tree = new MaxPathSum();
        Tree.insert(10);
        Tree.insert(2);
        Tree.insert(10);
        Tree.insert(20);
        Tree.insert(1);
        Tree.insert(-25);
        Tree.insert(3);
        Tree.insert(4);
        Tree.inorder(Tree.root);
        System.out.println();
        System.out.println("Maximum path sum is "+Tree.FindMaxPath(Tree.root));
    }
}
