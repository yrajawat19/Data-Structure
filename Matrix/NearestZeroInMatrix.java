package Matrix;

public class NearestZeroInMatrix {
    // Driver code
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1},
        };
        // Print input matrix
        System.out.println("Input matrix : ");
        print(matrix);
        // Store the output matrix return from nearestZero function .
        int[][] Output_matrix = nearestZero(matrix);
        // Print output_matrix
        System.out.println("Output matrix : ");
        print(Output_matrix);
    }

    // Function to print matrix
    private static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] nearestZero(int[][] matrix) {
        if (matrix.length == 0)
            return matrix;

        // Initialize, only "1" who neighbors "0" is determined. Kind of path trimming.
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 1 && !hasNeiberZero(i, j, matrix))
                    matrix[i][j] = matrix.length + matrix[0].length + 1;

        // Start from the determined "1"
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 1)
                    dfs(matrix, i, j, 1);

        return matrix;
    }

    private static void dfs(int[][] matrix, int x, int y, int val) {
        // Base case. Boundary condition and new value who is larger than the previous found value, terminates.
        if (x < 0 || y < 0 || y >= matrix[0].length || x >= matrix.length || (matrix[x][y] < val)) {
            return;
        }

        // Set it as new value
        matrix[x][y] = val;

        dfs(matrix, x + 1, y, matrix[x][y] + 1);
        dfs(matrix, x - 1, y, matrix[x][y] + 1);
        dfs(matrix, x, y + 1, matrix[x][y] + 1);
        dfs(matrix, x, y - 1, matrix[x][y] + 1);
    }

    private static boolean hasNeiberZero(int x, int y, int[][] matrix) {
        if (x - 1 >= 0 && matrix[x - 1][y] == 0)
            return true;
        if (x + 1 < matrix.length && matrix[x + 1][y] == 0)
            return true;
        if (y - 1 >= 0 && matrix[x][y - 1] == 0)
            return true;
        if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0)
            return true;

        return false;
    }
}
