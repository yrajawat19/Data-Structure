package Algorithms.DP;

import java.util.Scanner;

public class LongestRepeatingSubsequence {
    public static int LRS(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] DP = new int[n+1][n+1];

        for(int i = 0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i == 0 || j== 0)
                    DP[i][j] = 0;
                else if(c[i-1] == c[j-1] && i!=j)
                    DP[i][j] = DP[i-1][j-1]+1;
                else
                    DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);
            }
        }

        return DP[n][n];
    }
    public static void main(String[] args) {
        System.out.print("Enter a string :");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("length of Longest Repeating Subsequence is "+LRS(s));
    }
}
