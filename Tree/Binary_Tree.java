package Tree;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree {
    Node root;
    Node temp;
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

    public void preorder(Node temp)
    {
        if(temp == null)
            return;
        System.out.print(temp.key+" ");
            preorder(temp.left);
            preorder(temp.right);
    }

    public void postorder(Node temp)
    {
        if(temp == null)
            return;
        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.key+" ");
    }

    public void delete(int key)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(root.key == key)
            {
                root = null;
                return;
            }
            else
                return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null;
        Node keyNode = null;
        while(!q.isEmpty())
        {
            temp = q.peek();
            q.remove();
            if(temp.key == key)
                keyNode = temp;
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }

        if(keyNode != null)
        {
            int x = temp.key;
            deleteDeepest(temp);
            keyNode.key = x;
        }
    }

    public void deleteDeepest(Node delNode)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null;
        while(!q.isEmpty())
        {
            temp = q.peek();
            q.remove();
            if(temp == delNode)
            {
                temp = null;
                return;
            }
            if(temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }
                if(temp.left != null)
                {
                    if(temp.left == delNode)
                    {
                        temp.left = null;
                        return;
                    }
                    else
                        q.add(temp.left);

            }
        }
    }
    public static void main(String[] args)
    {
        Binary_Tree Tree = new Binary_Tree();
        Tree.insert(1);
        Tree.insert(2);
        Tree.insert(3);
        Tree.insert(4);
        Tree.insert(5);
        Tree.inorder(Tree.root);
        System.out.println();
        Tree.preorder(Tree.root);
        System.out.println();
        Tree.postorder(Tree.root);
        Tree.delete(2);
        Tree.delete(3);
        Tree.delete(4);
        Tree.delete(5);
        System.out.println();
        Tree.postorder(Tree.root);
    }
}
