package Algorithms.DP;
import java.util.HashMap;
import java.util.Scanner;

public class GridTraveler {
    static Double countPaths(int rows,int columns)
    {
        HashMap<String,Double> memo = new HashMap<>();
        return countPathsRec(rows,columns,memo);
    }
    static Double countPathsRec(int rows,int columns,HashMap<String,Double> memo)
    {
        String key = rows+","+columns;
        if(memo.containsKey(key))
            return memo.get(key);
        if(rows == 0 || columns == 0)
            return 0.0;
        if(rows == 1 && columns == 1)
            return 1.0;
        Double count = (double)countPathsRec(rows-1,columns,memo) +countPathsRec(rows,columns-1,memo);
        memo.put(key,count);
        return memo.get(key);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows length in grid :");
        int rows = sc.nextInt();
        System.out.println("Enter columns length in grid :");
        int columns = sc.nextInt();
        System.out.println(countPaths(rows,columns));
    }
}
