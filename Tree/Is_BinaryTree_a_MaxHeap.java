package Tree;

class BinaryTree
{
    public Node root;
    class Node
    {
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

    public void insert(int key)
    {
        root = insertRec(root,key);
    }
    public Node insertRec(Node temp,int key)
    {
        if(temp == null) {
            root = new Node(key);
            return root;
        }

            if(temp.left == null || temp.right != null)
            {
                temp.left = insertRec(temp.left,key);

            }
            else if(temp.right == null || temp.left != null) {
                temp.right = insertRec(temp.right, key);
            }
        return temp;
    }

    public void inorderTraversal(Node root)
    {
        if(root!=null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    int countNodes(Node root)
    {
        if(root == null)
            return 0;
        return(1+countNodes(root.left)+countNodes(root.right));
    }

    boolean isHeap(Node root)
    {
        if(root == null)
            return true;
        int nodeCount = countNodes(root);
        if(isCompleteUtil(root,1,nodeCount) == true && isHeapUtil(root) == true)
            return true;
        return false;
    }
    boolean isHeapUtil(Node root)
    {
        if(root.left == null && root.right == null)
            return true;
        if(root.right == null)
            return root.key>= root.left.key;
        else {
            if (root.key >= root.left.key && root.key >= root.left.key)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }

    boolean isCompleteUtil(Node root, int index, int number_nodes)
    {
        if(root == null)
            return true;
        if(index>=number_nodes)
            return false;
        return isCompleteUtil(root.left,2*index,number_nodes) &&
                isCompleteUtil(root.right,2*index+1,number_nodes);
    }

}
public class Is_BinaryTree_a_MaxHeap {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(30);
        tree.insert(40);
        tree.insert(13);
        tree.insert(2);
        tree.insert(89);
        tree.insert(59);
        tree.insert(74);
        tree.inorderTraversal(tree.root);
        System.out.println();
        if(tree.isHeap(tree.root))
            System.out.println("Binary tree is binary heap .");
        else
            System.out.println("Binary tree is not binary heap .");
    }
}
