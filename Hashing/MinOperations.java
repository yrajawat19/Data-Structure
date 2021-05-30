package Hashing;
import java.util.*;
public class MinOperations {
    static int minOperations(int arr[])
    {
        int size = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<size;i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        int max_count = 0;
        Set<Integer> set = map.keySet();
        for(int i:set)
            if(max_count <= map.get(i))
                max_count = map.get(i);

            return (size - max_count);


    }
    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1,5,6,2,3,8,4};
        printArr(arr);
        int result = minOperations(arr);
        System.out.println("Minimum operations need to be performed to make all elements equal : "+result);
    }
}
