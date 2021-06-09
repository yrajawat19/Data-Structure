package Algorithms.Search;

public class JumpSearch {
    static int search(int[] nums, int x)
    {
        int n = nums.length;
        int step = (int)Math.floor(Math.sqrt(n));
        int prev = 0;
        while(nums[Math.min(step,n)-1]<x)
        {
            prev = step;
            step = step + (int)Math.floor(Math.sqrt(n));
            if(prev>=n)
                return -1;
        }
        while(nums[prev]<x)
        {
            prev++;
            if(prev == Math.min(step,n))
                return -1;
        }

        if(nums[prev] == x)
            return prev+1;
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = { 4,7,9,11,14,16,17,19,24,34,58,59,63};
        int x = 17;
        print(nums);
        int pos = search(nums,x);
        if(pos == -1)
            System.out.println("Element does not exist in array .");
        else
            System.out.println("Element found at position : "+pos);
    }

    public static void print(int[] arr)
    {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
}
