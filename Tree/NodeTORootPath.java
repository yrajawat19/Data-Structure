package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NodeTORootPath {
    Node root;
    class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key ;
            left = null;
            right = null;
        }
    }
    public void insert(int key) {
        if(root == null) {
            root = new Node(key);
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
            if(temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    public boolean NodeToRootPath(ArrayList<Integer> path, int key, Node root) {
        if(root == null)
            return false;
        if(root.key == key) {
            path.add(root.key);
            return true;
        }
        boolean filc = NodeToRootPath(path,key,root.left);
        if(filc) {
            path.add(root.key);
            return true;
        }
        boolean filr = NodeToRootPath(path,key,root.right);
        if(filr) {
            path.add(root.key);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        NodeTORootPath t = new NodeTORootPath();
        t.insert(5);
        t.insert(4);
        t.insert(10);
        t.inorder(t.root);
        ArrayList<Integer> path = new ArrayList<>();
        t.NodeToRootPath(path,10,t.root);
        System.out.println(path);
    }

}
