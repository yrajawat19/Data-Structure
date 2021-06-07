package Arrays;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    static int lcs(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        int len = Integer.MIN_VALUE;
        for(int i:arr)
            set.add(i);
        for(int i:arr)
        {
            if(!set.contains(i-1))
            {
                int j = i;
                while(set.contains(j))
                    j++;
                len = Math.max(len,j-i);
            }
        }
        return len;
    }
    static void print(int[] arr)
    {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,9,3,10,4,20,2};
        System.out.println("Input Array : ");
        print(arr);
        System.out.println("length of Longest consecutive subsequence is "+lcs(arr));
    }
}
