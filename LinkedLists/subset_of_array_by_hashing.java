import java.util.HashSet;

public class subset_of_array_by_hashing {
    static boolean isSubset(int arr1[],int arr2[])
    {
        HashSet<Integer> hset = new HashSet<>();
        int m = arr1.length ;
        int n = arr2.length ;
        for(int i=0;i<m;i++)
        {
            if(!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }
        for(int i=0;i<n;i++)
        {
            if(!hset.contains(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int arr1[] = {11,1,13,21,3,7};
        int arr2[] = {11,3,7,1};
        if(isSubset(arr1,arr2))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not subset of arr1");

    }
}
