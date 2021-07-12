/* Java Program to find longest common prefix from arrays of string elements */
package Strings;
// Public class
public class LongestCommonPrefix {
    // Driver code
    public static void main(String[] args) {
        String[] arr = {"flower","flow","flourish","flight","floor","flop"};
        System.out.println("Input strings ");
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[0]+" ");
        System.out.println();
        System.out.println("Longest common prefix from input strings is "+longestcommonprefix(arr));
    }

    // Function to return longest common prefix
    public static String longestcommonprefix(String[] arr) {
        if(arr.length == 0 )
            return "";
        // Taking first element in array as prefix .
        String prefix = arr[0];
        // Iterating over string array from index 1 and checking if prefix has index 0 or not .
        for(int i = 1 ; i < arr.length ; i++) {
            while(arr[i].indexOf(prefix) != 0)
                // while prefix index is not 0 , until shorten the prefix from right .
                prefix = prefix.substring(0,prefix.length() - 1);
        }

        // after iterating over all elements in array , return the prefix .
        return prefix ;
    }
}
