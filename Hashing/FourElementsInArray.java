package Hashing;

import java.util.HashMap;

/* Given an array of distinct integers, find if there are two pairs (a, b) and (c, d)
such that a+b = c+d, and a, b, c and d are distinct elements.
If there are multiple answers, then print any of them.*/
public class FourElementsInArray {
    static class Pair {
        int first;
        int second;
        Pair(int f,int s)
        {
            first = f;
            second = s;
        }
    }
    private static void FindPair(int[] arr) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            for(int j=i+1;j< arr.length;j++)
            {
                int sum = arr[i]+arr[j];
                if(!map.containsKey(sum))
                    map.put(sum,new Pair(i,j));
                else
                {
                    Pair p = map.get(sum);
                    System.out.println("("+arr[p.first]+" + "+arr[p.second]+")"+" = "+"("+arr[i]+" + "+arr[j]+")");
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,3,5,6,7,8,9,1,4};
        FindPair(arr);
    }
}
