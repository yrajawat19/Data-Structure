package Tree;

import java.util.*;

public class LevelOrderTraversal {
    Node root;
    class Node
    {
        int key;
        Node left;
        Node right;
        Node (int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    public void insert(int key)
    {
        if(root == null)
        {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node temp = q.peek();
            q.remove();

            if(temp.left == null)
            {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
            if (temp.right == null)
            {
                temp.right = new Node(key);
                break;
            }
            else
            {
                q.add(temp.right);
            }
        }

    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().key);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String[] args) {
        LevelOrderTraversal Tree = new LevelOrderTraversal();
        Tree.insert(1);
        Tree.insert(2);
        Tree.insert(3);
        Tree.insert(4);
        Tree.insert(5);
        System.out.println(Tree.levelOrder(Tree.root));
    }
}
