/* Java Program to validate a Binary search tree .*/

class BST
{
    Node root;
    class Node{
        int key;
        Node left;
        Node right;
        Node()
        {

        }
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }

    BST()
    {
        root= null;
    }

    public void insert(int key)
    {
        root = insertRec(root,key);
    }

    public Node insertRec(Node root, int key)
    {
        if(root == null) {
            root = new Node(key);
            return root;
        }
        if(root.key>key)
            root.left = insertRec(root.left,key);
        else if(root.key<key)
            root.right = insertRec(root.right,key);
        return root;
    }

    public void inorder()
    {
        inorderRec(root);
    }
    public void inorderRec(Node root)
    {
        if(root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    // this method mainly calls inValidate method .
    public boolean isValidBST(Node root)
    {
        return isValidate(root,null,null);
    }
    /* returns true if tree is Binary search tree */
    /* Condition to be Binary search tree :
    * 1) left subtree's key value < root's key value .
    * 2) right subtree's key value > root's key value .
    * 3) Both left and right subtree should also be Binary search tree .
    * 4) Each node has a distinct key .*/
    public boolean isValidate(Node root,Integer max,Integer min)
    {
        // Base condition if root is null
        if(root==null)
            return true;
        // If left subtree's value is greater than root key
        // or right subtree's value is smaller than root key
        // if either case is true than tree is not BST hence function
        // returns false
        if(min!=null && min>=root.key || max!=null && max<=root.key)
            return false;
        // recursively traversing subtrees
        else
            return isValidate(root.left,root.key,min) && isValidate(root.right,max,root.key);
    }
    // This method mainly calls deleteNode method .
    public void delete(int key)
    {
        root = deleteNode(root,key);
    }

    public Node deleteNode(Node root, int key)
    {
        if(root == null)
            return root;
        // If deleting node is smaller than root key then recursively traverse in left subtree .
        if(root.key > key)
            root.left = deleteNode(root.left,key);
        // If deleting node is greater than root key then recursively traverse in right subtree .
        else if(root.key < key)
            root.right = deleteNode(root.right,key);
        else {
            // Nodes with single or no child.
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteNode(root.right,root.key);
        }
            return root;
    }

    public int minValue(Node root)
    {
        int minV = root.key;
        if(root!=null)
        {
            while(root.left !=null)
            {
                minV = root.left.key;
                root = root.left;
            }
        }
        return minV;
    }
}

public class Validate_BST
{
    public static void main(String[] args)
    {
        BST tree = new BST();
        tree.insert(20);
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(90);
        tree.inorder();
        System.out.println();
        if(tree.isValidBST(tree.root))
            System.out.println("Tree is Binary Search Tree .");
        else
            System.out.println("Tree is not Binary search tree");
        tree.delete(90);
        tree.inorder();
        System.out.println();
    }
}