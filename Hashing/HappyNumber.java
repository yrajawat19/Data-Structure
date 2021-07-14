/* A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.*/
package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {
    // Driver code
    public static void main(String[] args) {
        System.out.print("Enter number : ");
        Integer number = new Scanner(System.in).nextInt();
        System.out.println(isHappyNumber(number));
    }

    // Function to determine whether input number is happy number or not .
    private static Boolean isHappyNumber(Integer num) {
        /* Input: num = 19
           Output: true
           Explanation:
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1*/
        /* Input : num = 2
            Output : false
            Explanation :  2 , 4, 16 , 37 , 58 , 89 , 145 , 37
            37 is being repeated which means there is a cycle i.e sum of squares could never be 1 hence false .
         */
        // We will use HashSet to store sum .
        HashSet<Integer> seen = new HashSet<>();
        int SquareSum , remainder ;
        while(seen.add(num)) {
            SquareSum = 0 ;
            while(num > 0) {
                remainder = num % 10;
                SquareSum += remainder * remainder ;
                num /= 10 ;
            }

            if(SquareSum == 1)
                return true;
            else
                num = SquareSum;
        }

        return false;
    }
}
