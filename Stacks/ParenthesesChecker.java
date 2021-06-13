package Stacks;

import java.util.Stack;

public class ParenthesesChecker {
    public static boolean areStringValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char exp = s.charAt(i);
            if(exp == '(' || exp == '[' || exp == '{') {
                stack.push(exp);
                continue;
            }
            if(stack.isEmpty())
                return false;
            char check ;
            switch (exp)
            {
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if(check == '{' || check == '(')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if(check == '(' || check == '[')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }
    public static void main(String[] args) {
        String s1 = "{[][([])]}";
        String s2 = "{[}[})([]";
        if(areStringValid(s1)) {
            System.out.print(s1);
            System.out.println(" Expression is valid .");
        }
        else{
            System.out.print(s1);
            System.out.println(" Expression is not valid . ");
        }
        if(areStringValid(s2)) {
            System.out.print(s1);
            System.out.println(" Expression is valid .");
        }
        else {
            System.out.print(s1);
            System.out.println(" Expression is not valid . ");
        }
    }
}
