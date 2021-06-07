package Matrix;

public class SearchInSortedMatrix {
    static void search(int[][] matrix,int x)
    {
        int n = matrix.length;
        int i=0,j = n-1;
        while(i<n && j>=0) {
            if(matrix[i][j] == x)
            {
                System.out.println("Element "+x+" found at position : ("+i+","+j+")");
                return;
            }
            if(matrix[i][j]>x)
                j--;
            else
                i++;
        }
        System.out.println("Element not found !! ");
    }
    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int num1 = 39;
        int num2 = 199;
        search(matrix,num1);
        search(matrix,num2);
    }
}
