/* Java Program to calculate length of Longest common sub sequence . Program is using Dyanmic Programming Pardigm .*/
// Time Complexity = O(mxn) where m = length of 1st Substring and n = length of 2nd substring .
// If both strings are of same length then time complexity will be O(n^2) .

/* Problem Statement :
*  Given two sequences, find the length of longest subsequence present in both of them.
*  A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
* For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.*/
package Algorithms.DP;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "ABCDE"; // String 1
        String s2 = "AB"; // String 2
        char[] A = s1.toCharArray(); // String to char Array conversion of s1
        char[] B = s2.toCharArray(); // String to char Array conversion of s2
        int m = A.length; // m = length of char Array A
        int n = B.length; // n = length of char Array B
        char C[] = lcs(A,B,m,n); // result stores length of subsequence
        System.out.println("common subsequence of both array : "); // prints the result
        for(int i=0;i<C.length;i++)
            System.out.print(C[i]);
        System.out.println();
        System.out.println("Length of common subsequence is "+C.length);
    }

    private static char[] lcs(char[] a, char[] b, int m, int n) {
        int[][] L = new int[m+1][n+1]; // matrix
        char[] c = new char[n]; // size of char array C will be same as string 2 array .
        int k =0;
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if( i==0 || j==0)
                    L[i][j] = 0;
                else if(a[i-1]==b[j-1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                    c[k++] = b[j-1];
                }
                else
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
            }
        }
        return c;
    }
}
