package Algorithms.Search;

public class InterpolationSearch {
    public static void print(int[] nums)
    {
        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
    }
    static int search(int[] nums,int low,int high,int x)
    {
        int pos;
        if(low<=high && nums[low]<=x && nums[high]>=x)
        {
            pos = (low+(x-nums[low])/(nums[high]-nums[low])*(high-low));
            if(nums[pos] == x)
                return pos;
            if(nums[pos]<x)
                return search(nums,pos+1,high,x);
            else if(nums[pos]>x)
                return search(nums,low,pos-1,x);
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {45,55,65,75,85,95,105,115,125,135,145,155,165,175,185,195};
        print(nums);
        int x = 10;
        int pos = search(nums,0,nums.length-1,x) +1;
        if(pos == -1)
            System.out.println("Element does not exist in array .");
        else
            System.out.println("Element found at position : "+pos);
    }
}
