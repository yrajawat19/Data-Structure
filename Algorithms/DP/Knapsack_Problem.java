package Algorithms.DP;
public class Knapsack_Problem {
    // Function to calculate maximum profit in 0-1 knapsack problem .
    public static int knapsack(int[] wt , int[] profit , int W , int n) {
        int[][] table = new int[n+1][W+1];

        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j <=W;j++) {
                // Base case : when we don't have any items or knapsack bag is full .
                if(i == 0 || j == 0)
                    table[i][j] = 0;
                else if(wt[i-1] > j)
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = Math.max(table[i-1][j],table[i-1][j-wt[i-1]]+profit[i-1]);
            }
        }
        return table[n][W];
    }
    // Driver code
    public static void main(String[] args) {
        int wt[] = {10, 20, 30 };
        int profit[] = {60, 100, 120 };
        int W = 50;
        System.out.println("Maximum profit in knapsack is "+knapsack(wt,profit,W,wt.length));
    }
}