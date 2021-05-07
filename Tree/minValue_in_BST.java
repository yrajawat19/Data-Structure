public class minValue_in_BST {
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
    minValue_in_BST()
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
    public int minV()
    {
       int minv= minValue(root);
       return minv;
    }

    public int minValue(Node root)
    {
       int  minV = root.key;
        if(root!=null)
        {
            while(root.left != null)
            {
                minV = root.left.key;
                root = root.left;
            }
        }
        return minV;
    }

    public static void main(String[] args)
    {
        minValue_in_BST tree = new minValue_in_BST();
        tree.insert(798);
        tree.insert(234);
        tree.insert(214);
        tree.insert(123);
        tree.insert(897);
        tree.inorder();
        System.out.println();
        System.out.println("The minimum value in BST is "+ tree.minV());
    }
}
