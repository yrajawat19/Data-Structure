package Strings;

public class CheckRightRotationOfString {
    // Function to validate right rotation of given string .
    public static boolean isRightRotation(String string , String rotated_string) {

        int n = string.length();
        int m = rotated_string.length();

        // If two strings are of different length it means they are different strings , return false .
        if(n != m)
            return false;

        // lps array
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while(i < n) {
            if(string.charAt(i) == rotated_string.charAt(len)) {
                lps[i] = ++len;
                ++i;
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    ++i;
                } else len = lps[len-1];
            }
        }

        i = 0;

        for(int j = lps[n-1] ; j < m ; j++) {
            if(string.charAt(j) != rotated_string.charAt(i++))
                return false;
        }

        return true;

    }

    // Driver code
    public static void main(String[] args) {
        String string = "ABCD";
        // If string is right rotated for 2 times then string will "CDAB"
        String rotated_string = "BCDA";
        if(isRightRotation(string,rotated_string))
            System.out.println("True");
        else
            System.out.println("False");

    }


}
