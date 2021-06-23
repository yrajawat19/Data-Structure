package Arrays;

import java.util.HashMap;

public class CommonElementInThreeSortedArrays {
    public static void CommonElements(int[] arr1 , int[] arr2 , int[] arr3)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
            if(!map.containsKey(arr1[i]))
            map.put(arr1[i], 1);
        }
        for(int j = 0; j < arr2.length; j++) {
            if(map.containsKey(arr2[j]))
                map.put(arr2[j],map.get(arr2[j])+1);
        }
        for(int k = 0; k < arr3.length; k++) {
            if(map.containsKey(arr3[k])) {
                if(map.get(arr3[k])+1 == 3)
                    System.out.print(arr3[k] + " , ");
            }
        }
    }

    public static void print(int[] arr)
    {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr1[] = {2,3,5,6,8,9,12};
        int arr2[] = {1,3,4,5,6,8,10,12};
        int arr3[] = {5,9,10,12,14,16};
        System.out.println("Array 1 ");
        print(arr1);
        System.out.println("Array 2 ");
        print(arr2);
        System.out.println("Array 3 ");
        print(arr3);
        System.out.print("Common elements in 3 sorted arrays are ");
        CommonElements(arr1,arr2,arr3);
    }
}
