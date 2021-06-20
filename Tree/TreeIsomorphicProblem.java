package Tree;
import java.util.*;

public class TreeIsomorphicProblem {
    Node root;
    class Node {
        int key ;
        Node left ;
        Node right ;
        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }
    // Function to insert elements in Binary Tree .
    public void insert(int key)
    {
        if(root == null) {
            root = new Node(key);
            return ;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
            if(temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
    // Function to print inorder traversal of tree
    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    // Function to check whether trees are isomorphic or not .
    public boolean Isomorphic(Node n1 , Node n2) {
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null || n2 == null)
            return false;
        if(n1.key != n2.key)
            return false;

        return (Isomorphic(n1.left,n2.left) && Isomorphic(n2.left,n2.right)) || (Isomorphic(n1.left,n2.right) && Isomorphic(n1.right,n2.left));
    }

    // Driver Function
    public static void main(String[] args) {
        TreeIsomorphicProblem t1 = new TreeIsomorphicProblem();
        TreeIsomorphicProblem t2 = new TreeIsomorphicProblem();

        t1.insert(1);
        t1.insert(2);
        t1.insert(3);
        t1.inorder(t1.root);
        System.out.println();
        t2.insert(1);
        t2.insert(3);
        t2.insert(2);
        t2.inorder(t2.root);
        System.out.println();
        if(t1.Isomorphic(t1.root,t2.root))
                System.out.println("Yes");
        else
            System.out.println("No");
    }
}
