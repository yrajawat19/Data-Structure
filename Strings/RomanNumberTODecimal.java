package Strings;

import java.util.Scanner;

public class RomanNumberTODecimal {
    public static int val(char r)
    {
        if(r == 'I')
            return 1;
        if(r == 'V')
            return 5;
        if(r == 'X')
            return 10;
        if(r == 'L')
            return 50;
        if(r == 'C')
            return 100;
        if(r == 'D')
            return 500;
        if(r == 'M')
            return 1000;
        return -1;
    }
    public static int DecimalNumber(String s)
    {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            int s1 = val(s.charAt(i));
            if(i+1 < s.length()) {
                int s2 = val(s.charAt(i+1));
                if(s1 >= s2)
                    num += s1;
                else {
                    num = num + s2 -s1;
                    i++;
                }
            }
            else
                num = num + s1;
        }

        return num;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter roman number : ");
        String RomanNumber = sc.nextLine();
        System.out.print("Input roman number equivalent decimal number : "+DecimalNumber(RomanNumber));
    }
}
