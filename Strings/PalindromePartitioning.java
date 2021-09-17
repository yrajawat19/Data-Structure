package Strings;

import java.util.*;

public class PalindromePartitioning {
    //Driver code
    public static void main(String[] args) {
        String s = "AAB";
        System.out.println("Palindromic subsets are :");
        System.out.println(partition(s));
    }

    // Function to return arraylist of palindromic subsets .
    public static List<List<String>> partition(String s) {
        // Arraylist of arraylist storing subsets of original string which are palindromic .
        List<List<String>> result = new ArrayList<>();
        // Shell function to do all the work
        dfs(s,0,new ArrayList<String>(),result);
        // return result list .
        return result ;
    }

    // Function to backtrack and store all valid palindromic substrings .
    public static void dfs(String s, int index , List<String> current , List<List<String>> result ) {
        // if index is equals to string s size it means we have processed the string . now store the list of subsets in result ArrayList .
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        // else process the string from given index .
        else {
            // Start traversing string from index to end of string .
            for(int i = index ; i < s.length() ; i++) {
                // check if substring from index to i+1 position is palindrome or not .
                if(isPalindrome(s.substring(index,i+1))) {
                    // store substring in current arraylist .
                    current.add(s.substring(index,i+1));
                    // backtrack for remaining string .
                    dfs(s,i+1,current,result);
                    // remove last substring for backtracking .
                    current.remove(current.size()-1);
                }
            }
        }
    }

    // Function to validate palindrome string
    public static boolean isPalindrome(String s) {
        int low = 0 ;
        int high = s.length()-1;
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        }

        return true;
    }



}
