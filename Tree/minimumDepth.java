package Tree;

public class minimumDepth {
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

    public int minimum_depth(Node root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return minimum_depth(root.right) +1;
        if(root.right == null)
            return minimum_depth(root.left) +1;
        return Math.min(minimum_depth(root.left),minimum_depth(root.right)+1);
    }
    public static void main(String[] args) {
        minimumDepth Tree = new minimumDepth();
        Tree.insert(15);
        Tree.insert(13);
        Tree.insert(17);
        Tree.insert(11);
        Tree.insert(19);
        Tree.insert(4);
        Tree.insert(3);
        Tree.inorder();
        System.out.println();
        System.out.println("Minimum depth to the leaf node from root node : "+Tree.minimum_depth(Tree.root));
    }
}
