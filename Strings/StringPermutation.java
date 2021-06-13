package Strings;

import java.util.Scanner;

public class StringPermutation {
    public static void Permutations(String s , String asf)
    {
        if(s.length() == 0) {
            System.out.println(asf);
            return;
        }

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            String l = s.substring(0,i);
            String r = s.substring(i+1);
            String ros = l+r; // rest of string after removing ith character
            Permutations(ros,asf+ch);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String s = sc.nextLine();
        Permutations(s,"");
    }
}
