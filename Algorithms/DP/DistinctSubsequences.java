package Algorithms.DP;

public class DistinctSubsequences {
    //Driver code
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit" ;
        System.out.println("Distinct Subsequences : "+distinctSubsequence(s,t));
    }

    // Function to count distinct subsequences .
    public static int distinctSubsequence(String s , String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i<m+1 ; i++)
            dp[i][0] = 1;
        for(int j = 1; j <n+1 ; j++)
            dp[0][j] = 0;

        for(int i = 1; i < m+1 ; i++) {
            for(int j = 1; j < n+1 ; j++) {
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }

        return dp[m][n];
    }
}
