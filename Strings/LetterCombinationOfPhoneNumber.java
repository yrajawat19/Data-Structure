/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.*/
package Strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationOfPhoneNumber {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits of phone number : ");
        String digits = sc.nextLine();
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations are ");
        System.out.print(combinations);
    }
    // Function to return array list with letter combinations of phone number .
    private static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return combinations ;
        String[] mappings = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinationsRecursive("",0,digits,combinations,mappings);
        return combinations;
    }

    // Recursive function to fill combinations arraylist with letter combinations .
    private static void letterCombinationsRecursive(String current , int index , String digits , List<String> combinations , String[] mappings) {
        // when index gets equal to length of digits string then add current string in combinations list .
        if(index == digits.length()) {
            combinations.add(current);
            return;
        }
        // get the letters from mapping array .
        String letters = mappings[digits.charAt(index) - '0'];

        // iterate over letters string .
        for(int i = 0; i<letters.length(); i++)
            letterCombinationsRecursive(current+letters.charAt(i),index+1,digits,combinations,mappings);
    }
}
