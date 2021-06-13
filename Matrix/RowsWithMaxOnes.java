package Matrix;

public class RowsWithMaxOnes {
    public static int findRow(int[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int maxRow = 0;
        int row_until_here = 0;
        for(int i=0;i<rows;i++)
        {
            int count1s = 0;
            for(int j=0;j<columns;j++)
            {
                if(matrix[i][j] == 1)
                    count1s++;
            }
            if(row_until_here < count1s)
            {
                row_until_here = count1s;
                maxRow = i;
            }
        }

        return maxRow;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1,1},
                          {0,1,1,1},
                          {1,1,1,1},
                          {0,0,0,0},};
        System.out.println("Row with maximum no of 1s :"+findRow(matrix));
    }
}
