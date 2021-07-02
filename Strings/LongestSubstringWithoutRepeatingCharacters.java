package Strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    // Function to return length of longest substring without repeating characters .
    public static int longestSubstring(String s) {
        // Hashmap to keep track of visited characters .
        HashMap<Character,Integer> seen = new HashMap<>();
        int start = 0;
        int length = 0;
        // loop through string .
        for(int i = 0 ; i < s.length() ; i++) {
            if(seen.containsKey(s.charAt(i)))
                start = Math.max(start,seen.get(s.charAt(i)) + 1);
            seen.put(s.charAt(i),i);
            length = Math.max(length , i-start+1);
        }
        return length;
    }
    // Driver code
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters is "+longestSubstring(s1));
    }
}
