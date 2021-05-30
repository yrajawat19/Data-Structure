package Tree;
import java.util.ArrayList;

public class Pair_given_sum_inBST {
    Node root;

    class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
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

    ArrayList<Integer> treetoList (Node node,ArrayList<Integer> list)
    {
        if(node == null)
            return null;
        treetoList(node.left,list);
        list.add(node.key);
        treetoList(node.right,list);
        return list;
    }

    boolean isPairPresent(Node node,int target)
    {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = treetoList(node,a1);
        int start = 0;
        int end = a2.size() -1 ;
        while(start<end) {
            if (a2.get(start) + a2.get(end) == target) {
                System.out.println("Pair found for given sum " + target + " is " + a2.get(start) +" + "+ a2.get(end));
                return true;
            }
            if (a2.get(start) + a2.get(end) < target)
                start++;
            if (a2.get(start) + a2.get(end) > target)
                end--;
        }
        System.out.println("No pair found ");
        return false;
    }

    public static void main(String[] args)
    {
        Pair_given_sum_inBST tree = new Pair_given_sum_inBST();
        int keys[] = {39,13,26,65,52,78,104,91,130,117};
        for(int i:keys)
            tree.insert(i);
        tree.inorder();
        System.out.println();
        tree.isPairPresent(tree.root,39);
    }


}
