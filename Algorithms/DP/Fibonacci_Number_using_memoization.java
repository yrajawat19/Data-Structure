/* Java program to calculate Fibonacci value of given number . Program is optimized for polynomial time
* complexity using Dynamic Programming . Memoization technique is used in this program . */

package Algorithms.DP;
import java.util.*;
public class Fibonacci_Number_using_memoization {
    static int fib(int num)
    {
        // Array to store result of sub problems for future reuse
        int[] lookup = new int[100];
        // initializing elements in lookup array as nil
        for(int i=0;i<lookup.length;i++)
            lookup[i] = -1;
        // condition to check if array at index num has value stored or not.
        if(lookup[num] == -1)
        {
            if(num<2) // if number is smaller than 2 then simply store that number on index num
                lookup[num] = num;
            else // else calculate fibonacci value for that number and store it .
                lookup[num] = fib(num-2)+ fib(num -1);
        }
        // return value at index num in lookup array .
        return lookup[num];
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
