package Algorithms.DP;

import java.util.List;
import java.util.Arrays;
public class WordBreakProblem {
    // Function to determine if a string can be segmented into space-separated sequence of one or more strings .
    public static boolean wordBreak(List<String> dictionary , String s , int[] memo) {
        // return true if end of the string is reached .
        int n = s.length();
        if(n == 0)
            return true;

        // if the subproblem is seen for the first time .
        if(memo[n] == -1) {
            // mark subproblem as seen
            memo[n] = 0;

            for(int i = 1; i<=n;i++) {
                String prefix = s.substring(0,i);

                if(dictionary.contains(prefix) && wordBreak(dictionary,s.substring(i),memo))
                    memo[i] = 1;
                return true;
            }
        }
        return (memo[n] == 1);
    }
    // Driver code
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("amazon","car","laptop","bike");
        String s = "caramazon";
        int[] memo = new int[s.length()+1];
        Arrays.fill(memo,-1);

        if(wordBreak(dictionary,s,memo))
            System.out.println("The string can be segmented . ");
        else
            System.out.println("The sting can not be segmented . ");
    }
}
