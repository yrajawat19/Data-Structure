package Hashing;
import java.util.*;
/* Given an array with repeated elements, the task is to find the maximum distance two occurrences of an element.

Examples:

Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Output: 10
//maximum distance for 2 is 11-1 = 10
// maximum distance for 1 is 4-2 = 2
// maximum distance for 4 is 10-5 = 5 */
public class Max_distance_between_two_occurances{
    static void maxDistance(int[] arr)
    {
        int n = arr.length;
        int index = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max_dist = 0;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(arr[i]))
                map.put(arr[i],i);
            else {
                int intial_max = max_dist;
                max_dist = Math.max(max_dist, i - map.get(arr[i]));
                if(intial_max != max_dist) {
                     index = arr[i];
                }
            }
        }
        System.out.println("The maximum distance is "+max_dist+" between two occurances of "+index);
    }
    public static void main(String[] args) {
            Max_distance_between_two_occurances map = new Max_distance_between_two_occurances();

        int[] arr = {3, 4, 1, 2, 1, 2, 5, 8, 6, 7, 2, 4};
        map.maxDistance(arr);
    }
}
