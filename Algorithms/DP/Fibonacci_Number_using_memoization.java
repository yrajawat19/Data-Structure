/* Java program to calculate Fibonacci value of given number . Program is optimized for polynomial time
* complexity using Dynamic Programming . Memoization technique is used in this program . */

package Algorithms.DP;
import java.util.*;
public class Fibonacci_Number_using_memoization {
    static int fib(int num)
    {
        // Array to store result of sub problems for future reuse
        HashMap<Integer,Integer> lookup = new HashMap<>();
        // condition to check if HashMap at key num has value stored or not.
        if(lookup.containsKey(num))
            return lookup.get(num); // If map contains key then return the value .
        if(num <= 2) // if num is smaller or equal to 1 then return 1 .
            return 1;
        lookup.put(num,fib(num-1)+fib(num-2)); // calculate the fibonacci number and store it in HashMap.
        return lookup.get(num); // return that value from HashMap .
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Asking for user's input
        System.out.println("Enter a number to print its fibonacci number : ");
        // Taking user's input
        int num = sc.nextInt();
        System.out.println("Fibonacci value of "+num+" is "+fib(num));
    }
}
