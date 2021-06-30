package Algorithms.DP;

public class RodCuttingProblem {
    public static int maxProfit_by_rodcutting(int[] arr , int n) {
        int[] val = new int[n+1];
        val[0] = 0;
        for(int i=1;i<=n;i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0;j<i;j++)
                max = Math.max(max,val[i-j-1]+arr[j]);
            val[i] = max;
        }

        return val[n];
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = arr.length;
        System.out.println("Maximum profit from rod cutting is "+maxProfit_by_rodcutting(arr,n));
    }
}
