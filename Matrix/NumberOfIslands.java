/* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.*/
package Matrix;
public class NumberOfIslands {
    static int Islands(int[][] grid)
    {
        int rows = grid.length; // No of rows in grid .
        if(rows == 0) // If there are null rows then just return 0 .
            return 0;
        int columns = grid[0].length; // No of columns in grid .
        int noOfIslands = 0; // Variable to store number of islands .
        for(int i=0;i<rows;i++) // Outer for loop to traverse through rows
        {
            for (int j = 0; j < columns; j++) // Inner for loop to traverse columns in each rows
            {
                if (grid[i][j] == 1) { // If we encounter 1 in grid means its an island .
                    DFS(grid, rows, columns, i, j);  // calling function to perform DFS .
                    noOfIslands++; // Increase Islands count each time 1 is encountered in grid .
                }
            }
        }
        return noOfIslands;
    }
    // Function responsible for performing DFS .
    static void DFS(int[][] grid,int rows,int columns,int x,int y)
    {
        if(x<0 || y<0 || x>=rows || y>=columns || grid[x][y] != 1)
            return;
        grid[x][y] = 2;  // mark as visited
        DFS(grid,rows,columns,x-1,y); // Top
        DFS(grid,rows,columns,x+1,y); // Down
        DFS(grid,rows,columns,x,y-1); // Left
        DFS(grid,rows,columns,x,y+1); // Right
    }
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}}; // Test case 1 , islands = 3
        int[][] grid2 = {{1,0},{1,1}}; // Test case 2 , islands = 1
        int[][] grid3 = {{ 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 }}; // Test case 3 , islands = 5
        System.out.println("In test case 1 , No of Islands are " + Islands(grid1));
        System.out.println("In test case 2 , No of Islands are " + Islands(grid2));
        System.out.println("In test case 3 , No of Islands are " + Islands(grid3));
    }
}
