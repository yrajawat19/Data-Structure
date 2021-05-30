package Arrays;
import java.util.*;
public class Union_Intersection_of_arrays {
    public static void printArr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void intersection(int[] a1, int[] a2)
    {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<a1.length;i++)
            set.add(a1[i]);
        for(int i=0;i<a2.length;i++)
        {
            if(set.contains(a2[i]))
                list.add(a2[i]);
        }
        System.out.println("Intersection of two arrays are ");
        for(int i:list)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void union(int[] a1, int[] a2)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<a1.length;i++)
            set.add(a1[i]);
        for(int i=0;i<a2.length;i++)
            if(!set.contains(a2[i]))
                set.add(a2[i]);
            System.out.println("Union of two arrays are ");
            for(int i:set)
                System.out.print(i+" ");
            System.out.println();
    }
    public static void main(String[] args) {
        int a1[] = {2,3,4,5,6,7,8,9,10};
        int a2[] = {5,6,7,8,9,10,11,12};
        intersection(a1,a2);
        union(a1,a2);
    }
}
