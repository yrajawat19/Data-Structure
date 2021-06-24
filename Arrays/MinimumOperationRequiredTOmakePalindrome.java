package Arrays;

import java.util.Scanner;

public class MinimumOperationRequiredTOmakePalindrome {
    public static int countOperations(int[] arr)
    {
        int i = 0;
        int j = arr.length - 1;
        int operations = 0;
        while (i<=j)
        {
            if(arr[i] == arr[j]) {
                i++;
                j--;
            }
            else if(arr[i] > arr[j]) {
                j--;
                arr[j] += arr[j+1];
                operations++;
            }
            else  {
                i++;
                arr[i] += arr[i-1];
                operations++;
            }
        }

        return operations;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No of elements in an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in array : ");
        for(int i = 0 ; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Minimum no of operations required to make an array palindrome : "+countOperations(arr));

    }
}
