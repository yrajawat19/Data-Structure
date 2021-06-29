package Arrays;

import java.util.Scanner;

public class ProductOfArrayExceptItSelf {
    // Function to perform the operation on array .
    public static int[] productOfArray(int[] nums, int n)
    {
        int[] output = new int[n];
        int product ;

        product = 1;
        for(int i = 0 ; i < n ; i++) {
            product *= nums[i];
            output[i] = product;
        }

        product = 1;
        for(int i = n-1;i>0;i--) {
            output[i] = output[i-1] * product;
            product *= nums[i];
        }
        output[0] = product;

        return output;
    }
    // function to print array
    public static void print(int[] arr) {
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No of elements in array : ");
        int n = sc.nextInt();
        System.out.println("Enter elements in array : ");
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        System.out.println("Input array : ");
        print(arr);
        int[] output = productOfArray(arr,n);
        System.out.println("Output array : ");
        print(output);
    }
}
