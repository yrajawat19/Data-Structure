package Stacks;

import java.util.*;
public class MergeIntervals {
    public static class Interval{
        int st;
        int et;
        Interval(int st, int et)
        {
            this.st = st;
            this.et = et;
        }
    }
    public static void main(String[] args) {
        Interval[] arr = new Interval[6];
        arr[0] = new Interval(3,8);
        arr[1] = new Interval(5,12);
        arr[2] = new Interval(14,19);
        arr[3] = new Interval(22,28);
        arr[4] = new Interval(25,27);
        arr[5] = new Interval(27,30);
        MergeOverlappingIntervals(arr);
    }

    public static void MergeOverlappingIntervals(Interval[] arr) {
        Stack<Interval> stack = new Stack<>();
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.st - i2.st;
            }
        });

        stack.push(arr[0]);

        for(int i = 1; i < arr.length; i++)
        {
            Interval top = stack.peek();
            if(arr[i].st > top.et)
                stack.push(arr[i]);
            else if(arr[i].et > top.et) {
                top.et = arr[i].et;
                stack.pop();
                stack.push(top);
            }
        }

        System.out.println("Time Intervals are ");
        for(int i=0;i<arr.length;i++)
            System.out.println("[ "+arr[i].st+" - "+arr[i].et+" ]");

        System.out.println("Final Merged Time intervals are ");
        while(!stack.isEmpty()) {
            Interval interval = stack.pop();
            System.out.println("[ "+interval.st+" - "+interval.et+" ]");
        }
    }
}
