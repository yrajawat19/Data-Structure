package Matrix;

public class BinarySearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(isPresent(matrix,3));
    }
    public static boolean isPresent(int[][] matrix , int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if(rows == 0 && columns == 0)
            return false;

        int low = 0;
        int high = rows*columns -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            int value = matrix[mid/columns][mid%columns];

            if(value < target)
                low = mid+1;
            else if(value > target)
                high = mid-1;
            else
                return true;
        }

        return false;
    }
}
