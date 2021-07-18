/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().*/
package Strings;

public class IndexOfImplementation {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(indexOf(needle,haystack));
    }

    public static int indexOf(String needle , String haystack) {

        if(needle.length() == 0)
            return 0;

        if(haystack.length() == 0)
            return -1;

        for(int i = 0 ; i < haystack.length() ; i++) {
            if(i+needle.length() > haystack.length())
                break;
            for(int j = 0 ; j < needle.length() ; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if(j == needle.length()-1)
                    return i;
            }
        }

        return -1;
    }
}
