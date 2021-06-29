package Algorithms.Recursion;

public class ZeroOneKnapsack {
    static int knapsack(int[] wt , int[] profit , int W , int n) {
        if(n == 0 || W == 0)
            return 0;
        if(wt[n] > W)
            return knapsack(wt,profit,W,n-1);
        return Math.max(knapsack(wt,profit,W-wt[n],n-1)+profit[n],knapsack(wt,profit,W,n-1));
    }
    // Driver code
    public static void main(String[] args) {
        int wt[] = { 3,5,6,1,4,2};
        int profit[] = {20,30,10,60,40,50};
        int W = 10;
        System.out.println("Maximum profit in 0-1 Knapsack is "+knapsack(wt,profit,W,wt.length-1));
    }
}
