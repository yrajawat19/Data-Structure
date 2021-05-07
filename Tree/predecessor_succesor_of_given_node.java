/* We need to find the inorder successor and predecessor of a given key.
* In case the given key is not found in BST,
* then return the two values within which this key will lie. */


/*  ALGORITHM TO FIND PREDECESSOR AND SUCCESSOR OF A GIVEN NODE

Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree */
class PreSuc {
    Node root;
    class Node{
        int key;
        Node left;
        Node right;
        public Node()
        {

        }
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    PreSuc()
    {
        root = null;
    }
    // This method mainly calls insertRec method .
    public void insert(int key)
    {
        root = insertRec(root,key);
    }
    // Recursive method to insert values in Binary search tree .
    public Node insertRec(Node root, int key)
    {
        if(root==null)
        {
            root = new Node(key);
            return root;
        }
        if(key<root.key)
            root.left = insertRec(root.left,key);
        else if(key>root.key)
            root.right = insertRec(root.right,key);
        return root;
    }
    // This method mainly calls method responsible for inorder traversal .
    public void inorder()
    {
        inorderRec(root);
    }

    public void inorderRec(Node root)
    {
        if(root!= null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    Node pre = new Node();
    Node suc = new Node();
    public void preSuc(Node root, int key)
    {
        if(root == null)
            return;
        if(root.key == key)
        {
            if(root.left != null)
            {
                Node temp = root.left;
                while(temp.right != null)
                    temp = temp.right;
                pre = temp;
            }
            else if(root.right != null)
            {
                Node temp = root.right;
                while(temp.left!= null)
                    temp = temp.left;
                suc = temp;
            }
            return;
        }
        if(root.key>key)
        {
            suc = root;
            preSuc(root.left,key);
        }
        else
        {
            pre = root;
            preSuc(root.right,key);
        }
    }
}


public class predecessor_succesor_of_given_node {
    public static void main(String[] args)
    {
        PreSuc tree = new PreSuc();
        tree.insert(100);
        tree.insert(90);
        tree.insert(23);
        tree.insert(35);
        tree.insert(45);
        tree.insert(76);
        tree.insert(34);
        tree.inorder();
        System.out.println();
        tree.preSuc(tree.root,76);
        if(tree.pre != null)
            System.out.println("Predecessor is "+ tree.pre.key);
        else
            System.out.println("Predecessor is empty");
        if(tree.suc != null)
            System.out.println("Successor is "+tree.suc.key);
        else
            System.out.println("Successor is empty .");
    }
}
