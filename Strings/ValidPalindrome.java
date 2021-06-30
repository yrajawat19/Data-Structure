package Strings;

public class ValidPalindrome {
    public static void isValidPalindrome(String s) {
        if(isValidPalindromeRec(s))
            System.out.println(s+" is palindrome .");
        else
            System.out.println(s+" is not palindrome .");
    }

    private static boolean isValidPalindromeRec(String s) {
        if(s.isEmpty())
            return true;
        int head = 0;
        int tail = s.length() - 1;
        char character_at_head ;
        char character_at_tail ;

        while(head <= tail) {
            character_at_head = s.charAt(head);
            character_at_tail = s.charAt(tail);

            if(!Character.isLetterOrDigit(character_at_head))
                head++;
            else if(!Character.isLetterOrDigit(character_at_tail))
                tail--;
            else {
                if(Character.toLowerCase(character_at_tail) != Character.toLowerCase(character_at_head))
                    return false;
                head++;
                tail--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        isValidPalindrome(s1);
        isValidPalindrome(s2);
    }
}
