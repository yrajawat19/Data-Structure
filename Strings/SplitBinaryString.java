/* PROBLEM STATEMENT
* Given a binary string str of length N, the task is to find the maximum count
* of consecutive substrings str can be divided into such that
* all the substrings are balanced i.e. they have equal number of 0s and 1s.
* If it is not possible to split str satisfying the conditions then print -1*/
package Strings;

import java.util.Scanner;

public class SplitBinaryString {
    public static int countSubstrings(String s) {
        int count0 = 0;
        int count1 = 0;
        int count = 0;

        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == '0')
                count0++;
            else
                count1++;
            if(count1 == count0)
                count++;
        }
        return count == 0 ? -1 : count ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary string :");
        String s = sc.nextLine();
        System.out.println("No of substrings with balanced 0s and 1s : "+countSubstrings(s));
    }
}
