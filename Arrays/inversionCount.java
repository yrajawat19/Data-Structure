package Arrays;
import java.util.*;
public class inversionCount {
    public static void main(String[] args) {
        int[] nums = {2,4,5,1,10,7,9,3,8,6};
        print(nums);
        System.out.println("Total number of inversions in arrays are " + InversionC(nums));
    }
    // This method prints
    static void print(int[] nums)
    {
        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
    }
    // This method calls mergeSortCount for counting inversion in arrays .
    static int InversionC(int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;
        return mergeSortCount(nums,low,high);
    }
    // This method counts inversion in arrays with merge sort algorithm .
    static int mergeSortCount(int[] nums,int low,int high)
    {
        int count = 0;
        if(low<high)
        {
            int mid = (low + (high - low)/2);
            count += mergeSortCount(nums,low,mid);
            count += mergeSortCount(nums,mid+1,high);
            count += mergeCount(nums,low,mid,high);
        }
        return count;
    }

    // This method is responsible for merging the subarrays to single arrays and count inversion .
    static int mergeCount(int[] nums,int low,int mid,int high)
    {
        int[] L = Arrays.copyOfRange(nums,low,mid+1);
        int[] R = Arrays.copyOfRange(nums,mid+1,high+1);
        int i=0,j=0,k = low,swaps = 0;
        while(i<L.length && j<R.length)
        {
            if(L[i] < R[j])
                nums[k++] = L[i++];
            else {
                nums[k++] = R[j++];
                swaps += (mid+1) - (low+i);
            }
        }
        while(i<L.length)
            nums[k++] = L[i++];
        while(j<R.length)
            nums[k++] = L[j++];
        return swaps;
    }
}
