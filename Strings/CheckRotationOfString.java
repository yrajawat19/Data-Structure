package Strings;

public class CheckRotationOfString {
    static void checkRotation(String s1, String s2)
    {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        if((s1+s1).indexOf(s2) != -1 && s1.length() == s2.length())
            System.out.println(s2+ " is rotation of String "+s1);
        else
            System.out.println(s2+ " is not a valid rotation of String "+s1);
    }
    public static void main(String[] args) {
        String s1 = "mypencil";
        String s2 = "encilmyp";  // It is valid rotation of string s1
        String s3 = "pencilym";  // It is not a valid rotation of String s2
        checkRotation(s1,s2);
        checkRotation(s1,s3);
    }
}
