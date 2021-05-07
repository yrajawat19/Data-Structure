
class AVLTree
{
    Node root;
    class Node{
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
    int max(int a,int b)
    {
        return (a>b)?a:b;
    }
    int height(Node N)
    {
        if(N == null)
            return 0;
        return N.height;
    }
   public Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left),height(y.right))+1;
        x.height = max(height(x.left),height(y.right))+1;
        return x;
    }
    public Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left),height(x.right))+1;
        y.height = max(height(y.left),height(y.right))+1;
        return y;
    }

    public int getBalance(Node N)
    {
        if(N==null)
            return 0 ;
        return height(N.left)-height(N.right);
    }

    public Node insertRec(Node root,int key)
    {
        if(root == null)
            return (new Node(key));
        if(key<root.key)
            root.left = insertRec(root.left,key);
        else if(key>root.key)
            root.right = insertRec(root.right,key);
        else
            return root;

        root.height = 1+max(height(root.left),height(root.right));
        int balance = getBalance(root);
        if(balance >1 && key<root.left.key)
            return rightRotate(root);
        if(balance < -1 && key>root.right.key)
            return leftRotate(root);
        if(balance >1 && key>root.left.key)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance < -1 && key < root.right.key)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void insert(int key)
    {
        root = insertRec(root,key);
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

}
public class AVLTree_Insertion {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int keys[] = {23, 56, 75, 45, 5, 3, 324, 46, 564, 34, 324, 6, 546, 67,};
        for (int i : keys)
            tree.insert(i);

        tree.inorder();
        System.out.println();
    }
}
