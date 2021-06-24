package Strings;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class MinimumSwapsToBalanceBrackets {
    // Function to count minimum swaps to balance the string .
    public static long minSwaps(String s)
    {
        Vector<Integer> pos = new Vector<>();
        for(int i = 0 ; i < s.length() ; i++)
            if(s.charAt(i) == '[')
                pos.add(i);
        int p = 0;
        int count = 0;
        long sum = 0;
        char[] S = s.toCharArray();

        for(int i = 0 ; i < S.length ; i++) {
            if(S[i] == '[') {
                count++;
                p++;
            }
            else if (S[i] == ']')
                count--;

            if(count < 0) {
                sum += pos.get(p) - i;
                char temp = S[pos.get(p)];
                S[pos.get(p)] = S[i];
                S[i] = temp;
                p++;

                // reset count
                count = 1;
            }
        }

        return sum;
    }
    //Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string of Brackets : ");
        String s = sc.nextLine();
        System.out.println("Minimum swaps required to balance the brackets are "+minSwaps(s));
    }

}
