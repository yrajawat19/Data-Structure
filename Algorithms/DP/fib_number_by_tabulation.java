package Algorithms.DP;
import java.math.BigInteger;
import java.util.*;
public class fib_number_by_tabulation {
    static Double fib(int n) {
        Double[] F = new Double[n+1];
        F[0] = (double)0;
        F[1] = (double)1;
        for(int i=2;i<=n;i++)
            F[i] = F[i-1]+F[i-2];
        return F[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to print its fibonacci value : ");
        Integer n = sc.nextInt();
        System.out.println("Fibonacci value of number "+n+" is "+fib(n));
    }
}
