package Hashing;
import java.util.*;
public class DuplicateElements {
    static int[] findDuplicates(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int k=0;
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        for(int i=0;i<arr.length;i++)
            if(map.get(arr[i]) == 1)
                map.remove(arr[i]);

        int[] duplicates = new int[map.size()];
        for(int i=0;i<arr.length;i++)
            if(map.get(arr[i]) != null && map.get(arr[i]) > 1) {
                map.put(arr[i],1);
                duplicates[k++] = arr[i];
            }
            return duplicates;
    }
    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {12,54,765,32,656,34,56,23,75,12,65,34,65,34,76,54,656,765};
        int[] duplicates = findDuplicates(arr);
        System.out.println("Original Array : ");
        printArr(arr);
        System.out.println("Duplicate element in array : ");
        printArr(duplicates);
    }
}
