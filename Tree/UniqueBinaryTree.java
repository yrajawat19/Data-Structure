package Tree;

public class UniqueBinaryTree {
    public static void main(String[] args) {
        System.out.println("Unique binary search tree possible : "+numTrees(3));
    }

    public static int numTrees(int n) {

        int result = 0;
        if(n <= 1)
            return 1;
        for(int i = 0 ; i< n ; i++) {
            result += numTrees(i) * numTrees(n-i-1);
        }
        return result;
    }

}
