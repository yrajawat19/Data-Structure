package Algorithms.Search;

import java.util.Scanner;

public class ExponentialSearch {
    // Function to perform exponential search on array .
    public static int Exponential_search(int[] arr , int k) {
        if(arr[0] == k)
            return 0 ;
        int i = 1;
        while(i< arr.length && arr[i]<=k) {
            i = i*2;
        }
        return binarysearch(arr,i/2,Math.min(i,arr.length-1),k);
    }
    // Function to perform binary search on array .
    public static int binarysearch(int[] arr , int low , int high , int k) {
        if(low <= high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {2,4,5,7,8,9,10,14,16,19,23};
        System.out.println("Elements in array : ");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        System.out.println("Enter an element to search in array :");
        int k = sc.nextInt();
        int result = Exponential_search(arr,k);
        if(result == -1)
            System.out.println("Element is not found .");
        else
            System.out.println("Element found at position : "+ (result+1));
    }
}
