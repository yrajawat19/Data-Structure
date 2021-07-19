package Tree;
import java.util.*;
public class ConstructBTfromPreorderAndInorder {
    TreeNode root ;
    class TreeNode {
        int val ;
        TreeNode left ;
        TreeNode right ;
        TreeNode(int val) {
            this.val = val ;
            left = null ;
            right = null;
        }
    }
    // Function to print array .
    void print(int[] arr) {
        for(int i : arr)
            System.out.print(i+" ");
        System.out.println();
    }
    // Function to return constructed binary tree with preorder and inorder traversal .
    private TreeNode constructBinaryTree(int[] preorder , int[] inorder) {
        return constructBinaryTreeHelper(0,0,inorder.length-1,preorder,inorder);
    }
    // Function to construct binary tree .
    private TreeNode constructBinaryTreeHelper(int preStart , int inStart , int inEnd , int[] preorder , int[] inorder) {

        if(preStart > preorder.length-1 || inStart > inEnd)
            return null;
        // index 0 is root val in preorder traversal .
        TreeNode node = new TreeNode(preorder[preStart]);

        int inIndex = 0;

        for(int i = inStart ; i <= inEnd ; i++) {
            if(inorder[i] == node.val)
                inIndex = i;
        }
        // recursive call to construct left and right subtrees.
        node.left = constructBinaryTreeHelper(preStart+1, inStart,inIndex-1, preorder,inorder);
        node.right = constructBinaryTreeHelper(preStart+inIndex-inStart+1,inStart+1,inEnd,preorder,inorder);

        return node;
    }
    // Function to perform level order traversal of binary tree .
    private List<List<Integer>> levelOrder(TreeNode root) {
        // ArrayList to store level order traversal root's values .
        List<List<Integer>> result = new ArrayList<>();
        // Queue to store processing nodes .
        Queue<TreeNode> queue = new LinkedList<>();

        // if root is null , there is nothing to be done , just return .
        if(root == null)
            return result ;
        // add root in queue
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }

        return result;
    }
    // Driver code .
    public static void main(String[] args) {
        ConstructBTfromPreorderAndInorder Tree = new ConstructBTfromPreorderAndInorder();
        int[] preorder = {3,9,20,15,7};
        int[] inorder  = {9,3,15,20,7};
        Tree.root = Tree.constructBinaryTree(preorder,inorder);
        System.out.println("Preorder Traversal of Binary Tree : ");
        Tree.print(preorder);
        System.out.println("Inorder Traversal of Binary Tree ");
        Tree.print(inorder);
        System.out.println("Level Order Traversal of Binary Tree : ");
        System.out.println(Tree.levelOrder(Tree.root));

    }
}
