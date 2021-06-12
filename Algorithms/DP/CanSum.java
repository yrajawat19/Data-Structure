package Algorithms.DP;

import java.util.HashMap;
import java.util.Scanner;

public class CanSum {
    
    public static boolean isCanSum(int[] arr,int targerSum)
    {
        if(targerSum == 0)
            return true;
        if(targerSum < 0)
            return false;

        for(int i=0;i<arr.length;i++) {
            int remainder = targerSum - arr[i];
            if(isCanSum(arr,remainder))
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter elements in array :");
        for(int i=0;i<size;i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter target sum : ");
        int targetSum = sc.nextInt();
        if(isCanSum(arr,targetSum))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
