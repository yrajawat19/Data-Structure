/* Java program to demonstrate insertion and traversal in binary search tree */

/* Super class named Binary_Search_Tree  */
public class Binary_Search_Tree
{
    class Node
    {
        int key;
        Node left;
        Node right;
        Node(int key) // constructor of class Node to assign value to key
        {
            this.key = key;
            left = null;
            right =null;
        }
    }
    Node root;
    Binary_Search_Tree() // constructor of main class to assign null value to root
    {
        root=null;
    }
    // insert function to call insertRec function with argument root and key value
    public void insert(int key)
    {
        root = insertRec(root,key);
    }
    /* Function responsible for insert operation in binary search tree .
    * if key value is smaller than root value then key value will be stored in left node .
    * if key value is greater than root value then key value will be stored in right node .
    * if condition to root is null , if root is null then insert value is assigned to root .
    * value insertion is acheived through recursion . */
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
    // inorder function to call inorderRec function . This function is solely written for ease of user.
    public void inorder()
    {
        inorderRec(root);
    }
    /* Function responsible for inorder traversal of binary search tree .
    * Inorder traversal is achieved through recursion . */
    public void inorderRec(Node root)
    {
        //If condition to check root is not null .
        if(root!= null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    /* This method mainly calls deleteRec() */
    void deleteKey(int key)
    {
        root = deleteRec(root,key);
    }
    /* A recursive function to delete an existing key . */
    Node deleteRec(Node root, int key)
    {
        // Base case : if tree is empty .
        if(root==null)
            return root;
        /* Otherwise , recur down the tree*/
        if(key<root.key)
            root.left = deleteRec(root.left,key);
        else if(key>root.key)
            root.right = deleteRec(root.right,key);
        /* If key is same as root's key , then this is the node to be deleted. */
        else {
            // node with one child or no child
            if(root.left == null)
                return root.right;
            else if(root.right==null)
                return root.left;
            // node with two children : Get the inorder successor(smallest in right subtree )
            root.key = minValue(root.right);
            root.right = deleteRec(root.right,root.key);
        }
        return root;
    }

    int minValue(Node root)
    {
        int minV = root.key;
        while(root.left != null)
        {
            minV = root.left.key;
            root = root.left;
        }
        return minV;
    }

    public static void main(String[] args)
    {
        Binary_Search_Tree tree = new Binary_Search_Tree();
        tree.insert(50);
        tree.insert(70);
        tree.insert(40);
        tree.insert(90);
        tree.insert(20);
        tree.insert(10);
        tree.insert(100);
        tree.insert(60);
        tree.inorder();
        System.out.println();
        tree.deleteKey(10);
        System.out.println("Inorder traversal of Binary search tree after deletion of 10 .");
        tree.inorder();
    }
}