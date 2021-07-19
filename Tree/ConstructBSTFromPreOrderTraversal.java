package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBSTFromPreOrderTraversal {
    Node root ;
    class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    int NodeIdx ;
    public Node constructBST(int[] preorder) {
        if(preorder == null)
            return null;
        NodeIdx = 0;
        return preorderTraversal(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private Node preorderTraversal(int[] preorder,int start,int end) {
        if(NodeIdx == preorder.length || preorder[NodeIdx] < start || preorder[NodeIdx] > end)
            return null;
        
        int value = preorder[NodeIdx++];
        Node node = new Node(value);
        
        node.left = preorderTraversal(preorder,start,value);
        node.right = preorderTraversal(preorder,value,end);
        
        return node;
    }

    public List<List<Integer>> levelOrderTraversal(Node root) {
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
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }


    // Driver code
    public static void main(String[] args) {
        ConstructBSTFromPreOrderTraversal Tree = new ConstructBSTFromPreOrderTraversal();
        int[] preorder = {8,5,1,7,10,12};
        Tree.root = Tree.constructBST(preorder);
        System.out.println(Tree.levelOrderTraversal(Tree.root));
    }
}
