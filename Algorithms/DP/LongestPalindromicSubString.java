package Algorithms.DP;

import java.util.Scanner;

public class LongestPalindromicSubString {
    public static int lps(String s) {
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        int maxlength;
        int start = 0 ;
        // string of length 1 is always palindrome .
        maxlength = 1;
        for(int i = 0; i < n ; i++)
            table[i][i] = true;

        // check string of length 2 .
        for(int i = 0; i < n-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i + 1] = true;
                start = i;
                maxlength = 2;
            }
        }
        // check string of length more than 2 .
        for(int k = 3; k <= n ; k++)
        {
            for(int i = 0; i < n-k+1;i++) {
                int j = i+k -1;

                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxlength) {
                        start = i;
                        maxlength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindromic substring is ");
        printSubstring(s,start,start + maxlength-1);

        return maxlength;
    }
    public static void printSubstring(String s, int start , int end)
    {
        System.out.println(s.substring(start,end+1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String s = sc.nextLine();
        System.out.println("Longest palindromic substring is "+lps(s));

    }
}
