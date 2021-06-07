package Algorithms.DP;

public class Knapsack_Problem {
    static int knapSack(int[] val,int[] wt,int n,int W)
    {
        int K[][] = new int[n+1][W+1];
        int i,w;
        for(i=0;i<=n;i++)
        {
            for(w=0;w<=W;w++)
            {
                if(i == 0 || w == 0)
                    K[i][w] = 0;
                else if(wt[i-1] <= w)
                    K[i][w] = Math.max(K[i-1][w],K[i-1][w-wt[i-1]]+val[i-1]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
        return K[n][W];
    }
    public static void main(String[] args) {
        int[] val ={10,6,8};
        int[] wt = {2,3,5};
        int n = val.length;
        int W = 10;
        int maxProfit = knapSack(val,wt,n,W);
        System.out.println("Maximum Profit : "+maxProfit);
    }
}
