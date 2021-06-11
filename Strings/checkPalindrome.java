package Strings;

public class checkPalindrome {
    static boolean isPalindromeRec(String s,int start,int end)
    {
        if( start == end)
            return true;
        if(s.charAt(start) != s.charAt(end))
            return false;
        if(start<end+1)
            return isPalindromeRec(s,start+1,end-1);
        return true;
    }
    static void isPalindrome(String s)
    {
        int n = s.length();
        if(isPalindromeRec(s,0,n-1))
            System.out.println(s+ " is palindromic string .");
        else
            System.out.println(s+ " is not a palindromic string .");
    }
    public static void main(String[] args) {
        String test1 = "MALAYALAM";
        String test2 = "INDIA";
        isPalindrome(test1);
        isPalindrome(test2);
    }
}
