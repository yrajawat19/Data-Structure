package Arrays;

public class MedianOfTwoSortedArray {
    public static double FindMedian(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;
        int len = m+n;
        int i = 0 , j = 0;
        int[] arr3 = new int[len];
        int k = 0;
        double median = 0.0;
        while(i<m && j<n) {
            if(arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while(i<m)
            arr3[k++] = arr1[i++];
        while(j<n)
            arr3[k++] = arr2[j++];

        if(len%2 == 0)
        {
            median = ((arr3[len/2])+(arr3[(len/2)-1]))/2;
        }
        else
            median = arr3[len/2-1];

        return median;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        System.out.println(FindMedian(arr1,arr2));
    }
}
