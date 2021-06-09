package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class ele {
        int timestamp ; // to store timeframe
        int x; // to store x coordinates
        int y; // to store y coordinates
        ele(int x,int y,int timestamp)
        {
            this.x = x;
            this.y = y;
            this.timestamp = timestamp;
        }
    }
    static void print(int ans)
    {
        if(ans == -1)
            System.out.println("Not possible to rot all oranges .");
        else
            System.out.println("All oranges will be rotten in "+ans+" days .");
    }
    public static void main(String[] args) {
        int[][] grid1 = {{2,1,0,2,1},{1,0,1,2,1},{1,0,0,2,1}};  // Time to rot all oranges will be 2 days .
        int[][] grid2 = {{2,0},{0,1}};  // It is impossible to rot all oranges .
        int[][] grid3 = {{2,1,1},{1,1,0},{0,1,1}}; // Time to rot all oranges will be 4 days .
        int[][] grid4 = {{0,2}}; // Time to rot all oranges will be 0 days .
        print(rotOranges(grid1));
        print(rotOranges(grid2));
        print(rotOranges(grid3));
        print(rotOranges(grid4));

    }

    private static int rotOranges(int[][] grid)
    {
        Queue<ele> q = new LinkedList<>(); // Queue to track record of all rotten oranges in grid .
        int ans = 0;
        ele temp;
        int fresh = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2)
                    q.add(new ele(i, j, 0));
            }
        }
        while(!q.isEmpty())
        {
            temp = q.poll();

            if(temp.x-1 >=0 && temp.x<rows && temp.y<columns && temp.y>=0 && grid[temp.x-1][temp.y] == 1 )
            {
                q.add(new ele(temp.x-1,temp.y,temp.timestamp+1));
                grid[temp.x-1][temp.y] = 2;
                fresh--;
            }
            if(temp.x >=0 && temp.x+1<rows && temp.y<columns && temp.y>=0 && grid[temp.x+1][temp.y] == 1 )
            {
                q.add(new ele(temp.x+1,temp.y,temp.timestamp+1));
                grid[temp.x+1][temp.y] = 2;
                fresh--;
            }
            if(temp.x >=0 && temp.x<rows && temp.y<columns && temp.y-1>=0 && grid[temp.x][temp.y-1] == 1 )
            {
                q.add(new ele(temp.x,temp.y-1,temp.timestamp+1));
                grid[temp.x][temp.y-1] = 2;
                fresh--;
            }
            if(temp.x >=0 && temp.x<rows && temp.y+1<columns && temp.y>=0 && grid[temp.x][temp.y+1] == 1 )
            {
                q.add(new ele(temp.x,temp.y+1,temp.timestamp+1));
                grid[temp.x][temp.y+1] = 2;
                fresh--;
            }
            if(temp != null)
                ans = temp.timestamp;
        }
            if(fresh != 0)
                return -1;
        return ans;
    }
}
