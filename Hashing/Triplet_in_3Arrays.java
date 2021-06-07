/* Given three integer arrays and a “sum”, the task is to check
if there are three elements a, b, c such that a + b + c = sum
and a, b and c belong to three different arrays. */
package Hashing;
import java.util.HashSet;

public class Triplet_in_3Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1,4,6,9};
        int[] arr2 = {2,5,7,8};
        int[] arr3 = {3,4,6,8};
        int sum = 50;
        if(findNumbers(arr1,arr2,arr3,sum))
            System.out.println("Triplet is present .");
        else
            System.out.println("Triplet is not present .");
    }

    private static boolean findNumbers(int[] arr1, int[] arr2, int[] arr3, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++)
            set.add(arr1[i]);
        for(int j=0;j<arr2.length;j++) {
            for(int k=0;k<arr3.length;k++) {
                if(set.contains(sum - (arr2[j]+arr3[k])))
                    return true;
            }
        }
        return false;
    }
}
