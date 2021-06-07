/*Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1
(or true) then make all the cells of ith row and jth column as 1. */
package Matrix;
public class BooleanMatrix {
    static void modifyMatrix(int[][] matrix , int R, int C)
    {
        int[] row = new int[R];
        int[] column = new int[C];
        for(int i=0;i<R;i++)
            row[i] = 0;
        for(int j=0;j<C;j++)
            column[j] = 0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(matrix[i][j] == 1) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(row[i] == 1 || column[j] == 1)
                {
                    matrix[i][j] = 1;
                }
            }
        }
    }
    static void printMatrix(int[][] matrix,int R,int C)
    {
        for(int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 1},
                          {0, 0, 1, 0},
                          {0, 0, 0, 0},};
        System.out.println("Boolean Matrix :");
        printMatrix(matrix,3,4);
        modifyMatrix(matrix,3,4);
        System.out.println("Boolean Matrix after modification :");
        printMatrix(matrix,3,4);

    }
}
