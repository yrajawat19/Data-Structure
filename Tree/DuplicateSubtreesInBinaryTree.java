package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DuplicateSubtreesInBinaryTree {
    HashMap<String , Integer> map = new HashMap<>();
    Node root;
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public void insert(int data)
    {
        if(root == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(temp.left == null) {
                temp.left = new Node(data);
                break;
            }
            else
                q.add(temp.left);
            if(temp.right == null)
            {
                temp.right = new Node(data);
                break;
            }
            else
                q.add(temp.right);
        }
    }
    public void findDuplicateSubtrees() {
        inorder(root);
    }
    public String inorder(Node root) {

        if(root == null)
            return "";

        String str = "(";
        str += inorder(root.left);
        str += Integer.toString(root.data);
        str += inorder(root.right);
        str +=  ")";

        if(map.get(str) != null && map.get(str) == 1)
            System.out.println(root.data+" ");

        if(map.containsKey(str))
            map.put(str,map.get(str)+1);
        else
            map.put(str,1);

        return str;
    }
    public static void main(String[] args) {
        DuplicateSubtreesInBinaryTree tree = new DuplicateSubtreesInBinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.findDuplicateSubtrees();
    }
}
