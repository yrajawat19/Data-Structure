package Strings;
import java.util.*;
public class ValidParenthesisString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String s = sc.nextLine();
        if(validateParenthesis(s))
            System.out.println("Input string "+s+" is valid . ");
        else
            System.out.println("Input string"+s+" is not valid . ");

    }
    // Function to validate parenthesis in a string .
    private static boolean validateParenthesis(String s) {
        Stack<Integer> open = new Stack<>(); // Stack to store position of opening brackets in string .
        Stack<Integer> star = new Stack<>(); // Stack to store position of star in string .

        for(int i = 0 ; i < s.length() ; i++) {
            // If character at i position is "(" then store i in open stack .
            if (s.charAt(i) == '(')
                open.push(i);
                // else if character at i position is "*" then store i in star stack .
            else if (s.charAt(i) == '*')
                star.push(i);
                // else if character at i position is ")" then balance it .
            else {
                if (!open.isEmpty())
                    open.pop();
                else if (!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }

        // balancing opening brackets if any .
        while(!open.isEmpty()) {
            if(!star.isEmpty() && star.peek() > open.peek()) {
                star.pop();
                open.pop();
            }
            else
                return false;
        }
        return true;
    }

}
