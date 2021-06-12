package Matrix;

import java.util.ArrayList;

public class Rat_in_maze {
    static ArrayList<String> list = new ArrayList<>();
    public static boolean findPath(int[][] maze ,int x,int y)
    {
        if(x<0 || y<0)
            return false;
        list.add(x+","+y);
        if(x == 0 && y == 0)
            return true;
        if(x-1>=0 && maze[x-1][y] == 1)
            return findPath(maze, x - 1, y);

        if(y-1>=0 && maze[x][y-1] == 1)
            return findPath(maze, x, y - 1);
        return false;
    }
    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 1, 1 },
                         { 1, 0, 0, 1 },
                         { 1, 1, 1, 1 } };
        int N = maze.length;
        if(findPath(maze,N-1,N-1))
            System.out.println("True");
        else
            System.out.println("False");
        System.out.println(list);
    }
}
