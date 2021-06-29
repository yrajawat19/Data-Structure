package Algorithms.DP;

import java.util.Scanner;

public class EditDistance {
    // Function to return distance between two strings .
    public static int editDist(String s1 , String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] table = new int[m+1][n+1];

        for(int i = 0 ; i<=m; i++) {
            for(int j = 0 ; j<=n; j++) {

                // if s1 is null , then only option is to add all characters from s2.
                if(i == 0)
                    table[i][j] = j;
                // If s2 is null , then only option is to add all characters from s1.
                else if(j == 0)
                    table[i][j] = i;
                // If both characters are same then no operation need to be performed .
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    table[i][j] = table[i-1][j-1];
                else              // operations : replace   ,  remove ,  insert .
                    table[i][j] = 1+Math.min(table[i-1][j-1],Math.min(table[i-1][j],table[i][j-1]));
            }
        }

        return table[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s1 : ");
        String s1 = sc.nextLine();
        System.out.print("Enter string s2 : ");
        String s2 = sc.nextLine();
        System.out.println("Minimum operations required to make both strings equal : "+editDist(s1,s2));
    }
}
