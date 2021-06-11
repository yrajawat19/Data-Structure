/* Given an array of words, print all anagrams together. */
package Strings;
import java.util.*;
public class GroupAnagrams {
    // Method responsible for printing anagrams .
    public static void groupAnagrams(String[] Words)
    {

        // HashMap to store sorted letters as keys and words as an array associated with key.
        HashMap<String,List<String>> map = new HashMap<>();
        // traversing Words array
        for(String s:Words) {
            String word = s; // Storing array element in String named word .
            char[] letters = word.toCharArray(); // converting string to char array .
            Arrays.sort(letters); //sorting the char array .
            String newWord = new String(letters); //convertig char array back to string .
            //checking if map contains sorted word Key .
            if(map.containsKey(newWord))
                map.get(newWord).add(word); // if key exist then storing anagram in list.
            else {
                // else creating a list
                List<String> words = new ArrayList<>();
                // adding word in list .
                words.add(word);
                // putting key and value pair in HashMap .
                map.put(newWord,words);
            }
        }

        // Printing the groups of anagrams
        for(String s:map.keySet())
        {
            List<String> values = map.get(s);
            if(values.size() >1)
                System.out.println(values);
        }
    }
    public static void main(String[] args) {
        String[] words = {"cat","tac","god","eat","ate","tea","dog","goat","atog","young"};
        groupAnagrams(words);
    }
}
