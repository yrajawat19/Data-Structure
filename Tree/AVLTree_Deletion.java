/* Java Program to perform operations on AVL Tree such as creation , insertion , updation ,traversal and deletion of given node .*/
class AVL
{
    // Node subclass defining structure of node in AVL Tree .
    Node root;
    class Node
    {
        int key;
        int height;
        Node left;
        Node right;
        Node(int key)
        {
            this.key = key;
            height = 1;

        }
    }
    // Non parametrized constructor to set root to null value intially .
    AVL()
    {
        root = null;
    }

    public int getBalance(Node root)
    {
        if(root == null)
            return 0;
        return height(root.left)-height(root.right);
    }

    public void insert(int key)
    {
        root = insertRec(root,key);
    }
    // Utility function to perform insertion operation on AVL Tree .
    public Node insertRec(Node root, int key)
    {
        // 1. insert the node
        if(root == null)
        {
            root = new Node(key);
            return root;
        }
        // if given key is small than root key then recursively insert the key in left subtree .
        if(key<root.key)
            root.left = insertRec(root.left,key);
            // if given key is greater than root key then recursively insert the key in right subtree .
        else if(key>root.key)
            root.right = insertRec(root.right,key);
            // duplicate nodes are not allowed .
        else
            return root;

        // 2. Update height of the inserted node
        root.height = 1+ max(height(root.left),height(root.right));

        // 3. Get the balance factor of ancestor node to check whether this node became unbalanced.
        int balance = getBalance(root);

        // If this node became unbalances there are possibly 4 cases .
        // left left case
        if(balance>1 && key<root.left.key)
            return rightRotate(root);
        // left right case
        if(balance>1 && key>root.left.key)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right right case
        if(balance<-1 && key>root.right.key)
            return leftRotate(root);
        // Right left case
        if(balance<-1 && key<root.right.key)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    // Utility method for returning the height of node.
    public int height(Node root)
    {
        if(root == null)
            return 0;
        return root.height;
    }
    // Utility method for returning max element from given two elements
    public int max(int a,int b)
    {
        return (a>b) ? a : b;
    }
    // Utility method for left rotation of nodes
    public Node leftRotate(Node x)
    {
        Node y = x.right;
        Node temp = y.left;
        y.left = x;
        x.right = temp;

        x.height = 1+max(height(x.left),height(x.right));
        y.height = 1+max(height(y.left),height(y.left));

        return y;

    }
    // Utility method for right rotation of nodes
    public Node rightRotate(Node y)
    {
        Node x = y.left;
        Node temp = x.right;
        x.right = y;
        y.left = temp;

        y.height = 1+max(height(y.left),height(y.right));
        x.height = 1+max(height(x.left),height(x.right));
        return x;

    }
    // Utility method for inorder traversal of AVL Tree .
    public void inorder(Node root)
    {
        if(root != null)
        {

            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    // Utility method for preorder traversal of AVL Tree.
    public void preorder(Node root)
    {
        if(root != null)
        {

            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    // Utility method for post order traversal of AVL Tree .
    public void postorder(Node root)
    {
        if(root != null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ");
        }
    }

    // Utility method to delete given node in AVL Tree.
    public Node deleteNode(Node root, int key)
    {
        // Base case
        if(root == null)
            return root;
        // If given key is smaller than root key then search in left subtree .
        if(key<root.key)
            root.left = deleteNode(root.left,key);
        // If given key is greater than root key then search in right subtree .
        else if(key>root.key)
            root.right = deleteNode(root.right,key);
        // If given key is root key .
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteNode(root.right,root.key);
        }
        root.height = max(height(root.left),height(root.right)) + 1;
        int balance = getBalance(root);
        if(balance>1 && getBalance(root.left)>=0)
            return rightRotate(root);
        if(balance<-1 && getBalance(root.right)<=0)
            return leftRotate(root);
        if(balance>1 && getBalance(root.left)<0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance <-1 && getBalance(root.right)>0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public int minValue(Node root)
    {
        int minV = 0;
        Node current = root;
        while(current.left != null)
            current = current.left;
        minV = current.key;
        return minV;
    }

}

public class AVLTree_Deletion {
    public static void main(String[] args) {
        AVL tree = new AVL();
        int keys[] = {12,54,656,87,654,5346,767,4,543,5437,67,423};
        for(int i:keys)
            tree.insert(i);
        tree.inorder(tree.root);
        System.out.println();
        tree.deleteNode(tree.root,5346);
        tree.inorder(tree.root);
        System.out.println();
    }
}
