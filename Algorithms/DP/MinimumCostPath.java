package Algorithms.DP;

public class MinimumCostPath {
    public static int minimumCost(int[][] grid)
    {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] cost = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(i == 0 && j== 0)
                    cost[i][j] = grid[i][j];
                else if( i == 0 && j!=0)
                    cost[i][j] = grid[i][j] + cost[i][j-1];
                else if( j == 0 && i!=0)
                    cost[i][j] = grid[i][j] + cost[i-1][j];
                else
                    cost[i][j] = Math.min(cost[i-1][j],cost[i][j-1]) + grid[i][j];

            }
        }

        return cost[rows-1][columns-1];
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println("Minimum cost to travel from left most column to right most column is "+minimumCost(grid));
    }
}
