/* You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.*/
package Strings;

public class FormattingLicenseKey {
    public static void main(String[] args) {
        String Test1 = "5F3Z-2e-9-w";
        int T1 = 4;
        String Test2 = "2-5g-3-J";
        int T2 = 2;
        System.out.println("Test 1's License key : "+licenseKey(Test1,T1));
        System.out.println("Test 2's License key : "+licenseKey(Test2,T2));

    }

    // Function to format license key .
    private static String licenseKey(String str, int k) {
        StringBuilder result = new StringBuilder();
        int count = 0 ;
        int i = str.length()-1;
        while(i>=0) {
            Character current = Character.toUpperCase(str.charAt(i));
            if(current == '-')
                i--;
            else if(count != 0 && count%k == 0) {
                result.insert(0,'-');
                count = 0;
            }
            else {
                result.insert(0,current);
                i--;
                count++;
            }
        }

        return result.toString();
    }
}
