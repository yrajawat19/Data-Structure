package Strings;

import java.util.*;

public class PermutationSequence {
    // Function to return permutation sequence at index k
    private static String getPermutation(int n, int k) {

        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        for(int i = 1; i <= n; i++)
            numbers.add(i);

        k--;

        for(int i=1; i<=n; i++) {
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index*factorial[n-i];
        }

        return sb.toString();

    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number for permutations : ");
        int n = sc.nextInt();
        System.out.print("Enter Sequence number : ");
        int k = sc.nextInt();
        System.out.println(getPermutation(n,k));
    }
}
