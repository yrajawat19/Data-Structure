package Algorithms.Search;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {2,4,5,7,8,9,10,14,16,19,23};
        System.out.println("Elements in array : ");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        System.out.println("Enter an element to search in array :");
        int k = sc.nextInt();
        int result = search(arr,k);
        if(result == -1)
            System.out.println("Element is not found .");
        else
            System.out.println("Element found at position : "+ (result+1));
    }
    public static int search(int[] arr, int k)
    {
        int Size = arr.length;
        int l = 0;
        int r = Size-1;
        while(l<=r)
        {
            int mid = l+((r-l)/2);
            if(arr[mid] == k)
                return mid;
            else if(k<arr[mid])
                r=mid-1;
            else if(k>arr[mid])
                l = mid+1;
        }
        return -1;
    }
}
