package Arrays;

public class SearchInRotatedSortedArray {
    // Function to search element in rotated array .
    public static int search(int[] arr , int key) {
        int n = arr.length;
        int pivot = findPivot(arr,0,n-1);

        if(pivot == -1)
            return BinarySearch(arr,0,n-1,key);
        if(arr[pivot] == key)
            return pivot;
        if(arr[0] >= key)
            return BinarySearch(arr,pivot+1,n-1,key);
        return BinarySearch(arr,0,pivot-1,key);
    }
    // Function to binary search in array .
    private static int BinarySearch(int[] arr, int low, int high, int key) {

        if(low>high)
            return -1;
        int mid = low + (high-low)/2;

        if(arr[mid] == key)
            return mid;
        if(key > arr[mid])
            return BinarySearch(arr,mid+1,high,key);
        return BinarySearch(arr,low,mid-1,key);
    }

    // Function to find pivot element in rotated array .
    public static int findPivot(int[] arr ,int low,int high) {
        if(high < low)
            return -1;
        if(low == high)
            return low;
        int mid = low + (high - low)/2;

        if(mid < high && arr[mid] > arr[mid+1])
            return mid;
        if(mid > low && arr[mid] < arr[mid-1])
            return mid-1;
        if(arr[low] >= arr[mid])
            return findPivot(arr,low,mid-1);
        return findPivot(arr,mid+1,high);

    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int key = 6;
        int i = search(arr,key);
        if( i == -1)
            System.out.println("Element is not found .");
        else
            System.out.println("Element "+key+" is found at postion "+i);
    }
}
