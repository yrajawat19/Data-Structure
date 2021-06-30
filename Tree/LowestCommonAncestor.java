package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
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

    public void inorder(NodeTORootPath.Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }

    // Function to get path from particular node to root .
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

    public int lca(Node root ,int p , int q) {
        ArrayList<Integer> Path_of_p = new ArrayList<>();
        ArrayList<Integer> Path_of_q = new ArrayList<>();
        NodeToRootPath(Path_of_p,p,root);
        NodeToRootPath(Path_of_q,q,root);

        int i = Path_of_p.size() - 1;
        int j = Path_of_q.size() - 1;
        while(i>=0 && j>=0 && Path_of_p.get(i) == Path_of_q.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;

        return Path_of_p.get(i);
    }

    public static void main(String[] args) {
        LowestCommonAncestor t = new LowestCommonAncestor();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        System.out.println("lca : "+t.lca(t.root,7,6));
    }
}
