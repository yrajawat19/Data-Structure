package Strings;
import java.util.Stack;
public class LongestValidSubstring {
    public static void main(String[] args) {
        String s1 = ")()())";
        String s2 = "(()()()())";
        System.out.println("Length of longest valid substring : "+longestSubstring(s1));
        System.out.println("Length of longest valid substring : "+longestSubstring(s2));
    }

    // Function to return length of longest valid substring .
    private static int longestSubstring(String s) {
        int longest = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        // iterating over string
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                if(!stack.empty())
                    stack.pop();
                if(!stack.empty())
                    longest = Math.max(longest,i-stack.peek());
                else
                    stack.push(i);
            }
        }

        return longest;
    }
}
