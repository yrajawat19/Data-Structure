package Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarrayOfsizeK {
    public static void findMax(int[] arr , int k)
    {
        Deque<Integer> deque = new LinkedList<>();
        int i;
        for(i=0;i<k;++i)
        {
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }

        for(; i < arr.length; ++i)
        {
            System.out.print(arr[deque.peek()]+" ");
            while(!deque.isEmpty() && deque.peek() <= i-k)
                deque.removeFirst();
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        // print the maximum element of last window .
        System.out.print(arr[deque.peek()]+" ");
    }
    public static void main(String[] args) {
        int[] arr = {12, 1, 78, 90, 57, 89, 56 };
        int k  = 3;
        findMax(arr,k);
    }
}
