package Algorithms.BackTracking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class GenerateParenthesis {
    //Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of brackets : ");
        int num = sc.nextInt();

        System.out.println("Generated Valid parenthesis");
        System.out.println(generateParenthesis(num));
    }
    // Function to return list of all valid generated parenthesis .
    private static List<String> generateParenthesis(int num) {
        List<String> brackets = new ArrayList<String>();
        parenthesisGenerator(brackets, num, "", 0, 0);
        return brackets;
    }

    // Function to generate valid parenthesis using backtracking .
    private static void parenthesisGenerator(List<String> brackets, int max, String current, int open , int close) {
        if(current.length() == max*2) {
            brackets.add(current);
            return;
        }

        if(open < max)
            parenthesisGenerator(brackets, max,current+"(",open+1,close);
        if(close < open)
            parenthesisGenerator(brackets, max, current+ ")", open,close+1);

    }
}
