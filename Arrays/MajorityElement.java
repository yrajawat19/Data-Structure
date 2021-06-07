/* Write a function which takes an array and prints the majority element (if it exists),
otherwise prints “No Majority Element”. A majority element in an array A[] of size n is an
element that appears more than n/2 times (and hence there is at most one such element). */
package Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void majorityElement(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                int count = map.get(arr[i])+1;
                if(count>arr.length/2) {
                    System.out.println("Majority Element exist and It is " + arr[i]);
                    return;
                }
                else
                    map.put(arr[i],count);
            }
            else
                map.put(arr[i],1);
        }
        System.out.println("No majority element exist .");
    }
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,1,1,};   // Majority element is 1.
        int[] arr2 = new int[] {3,4,4,8,}; // No Majority element exist .
        majorityElement(arr1);
        majorityElement(arr2);
    }
}
