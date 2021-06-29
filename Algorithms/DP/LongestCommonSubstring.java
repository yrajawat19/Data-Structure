package Algorithms.DP;

import java.util.Scanner;

public class LongestCommonSubstring {
    // Function to calculate length of longest common string .
    public static int longestCommonString(String s1 , String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] table = new int[m+1][n+1];
        int result = 0;
        for(int i = 0 ; i <=m; i++) {
            for(int j = 0; j <=n; j++) {
                if(i == 0 || j == 0)
                    table[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                    result = Math.max(result , table[i][j]);
                }
                else
                    table[i][j] = 0;
            }
        }

        return result;
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string S1 :");
        String s1 = sc.nextLine();
        System.out.print("Enter string s2 :");
        String s2 = sc.nextLine();
        System.out.println("Length of longest common substring is "+longestCommonString(s1,s2));
    }
}
