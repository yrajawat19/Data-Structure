/* order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.

Return any permutation of str (as a string) that satisfies this property.*/
package Strings;

public class CustomSortStrings {
    public static void main(String[] args) {
        String order = "cba";
        String str = "abcd";
        System.out.println(customSort(order,str));
    }

    public static String customSort(String order , String str) {
        int[] freq = new int[26];
        for(char c : str.toCharArray())
            freq[c-'a']++;

        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()) {
            for(int i = 0; i < freq[c-'a'];i++)
                result.append(c);
            freq[c-'a'] = 0;
        }

        for(int i = 0; i< 26 ; i++) {
            for(int j = 0 ; j < freq[i];j++)
                result.append((char)(i+'a'));
        }

        return result.toString();
    }
}
