package Algorithms.Search;
import java.util.*;
public class LinearSearch {
    public static boolean search(int[] arr,int k)
    {
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == k) {
                System.out.println("Element found at position : " + (i + 1));
                return true;
            }
        }
         return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter size of array :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in array : ");
        for(int i = 0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter the element to search :");
        int k = sc.nextInt();
        if(!search(arr,k))
            System.out.println("Element not found !!");
    }
}
