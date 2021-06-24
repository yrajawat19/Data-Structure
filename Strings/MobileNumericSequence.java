package Strings;

import java.util.Scanner;

public class MobileNumericSequence {
    // Driver code
    public static void main(String[] args) {
        String[] keys =
                {       "2","22","222",
                        "3","33","333",
                        "4","44","444",
                        "5","55","555",
                        "6","66","666",
                        "7","77","777","7777",
                        "8","88","888",
                        "9","99","999","9999",
                };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string in uppercase : ");
        String sentence  = sc.nextLine();
        System.out.println("Input string : "+sentence);
        printKeypadSequence(keys,sentence);

    }
    // Function to print keypad numeric sequence .
    private static void printKeypadSequence(String[] keys, String sentence) {
        String output = "";
        for(int i = 0 ; i < sentence.length() ; i++)
        {
            if(sentence.charAt(i)== ' ')
                output += 0;
            else {
                int position = sentence.charAt(i) - 'A';
                output += keys[position];
            }
        }

        System.out.println("Numeric sequence : "+output);
    }
}
