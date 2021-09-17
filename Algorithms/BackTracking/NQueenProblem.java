package Algorithms.BackTracking;

public class NQueenProblem {
    static final int N = 4;
    // Driver code
    public static void main(String[] args) {
        // Board of size 4X4 .
        int[][] board = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        if(!SolveNQ(board,0))
            System.out.println("Solution does not exist . ");

        // Printing output board .
        PrintSolution(board);
    }

    // Recursive function to solve N queen puzzle using backtracking approach  .
    public static boolean SolveNQ(int board[][] , int column ) {
        // if column reaches N queen it means we were able to place all queens , return true .
        if(column >= N)
            return true;
        for(int row = 0; row < N ; row++) {
            // check if it's safe to place Queen at this index .
            if (isSafe(board, row, column)) {
                // if safe then place the queen in board .
                board[row][column] = 1;
                // check for next queen .
                if (SolveNQ(board, column + 1))
                    return true;

                board[row][column] = 0;
            }
        }
        return false;
    }

    // function to return if its safe to place a queen at given index .
    private static boolean isSafe(int[][] board , int row , int column) {
        int i , j;
        for(i = 0; i < column ; i++)
            if(board[row][i] == 1)
                return false;
        for(i = row ; i>=0 ; i--) {
            for(j = column ; j>=0 ; j--) {
                if(board[i][j] == 1)
                    return false;
            }
        }

        for(i = row ; i < N ; i++) {
            for(j = column ; j>=0 ; j--) {
                if(board[i][j] == 1)
                    return false;
            }
        }

        return true;
    }

    // Function to print board .
    public static void PrintSolution(int[][] board) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
