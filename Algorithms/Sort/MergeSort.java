package Algorithms.Sort;

public class MergeSort {
    public static void mergeSort(int[] arr)
    {
        int r = arr.length - 1;
        int l = 0;
        mergeSortUtil(arr,l,r);
        printArr(arr);
    }

    private static void mergeSortUtil(int[] arr, int l, int r) {
        if(l<r)
        {
            int mid = l + ((r-l)/2);
            mergeSortUtil(arr,l,mid);
            mergeSortUtil(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++)
            L[i] = arr[l+i];
        for(int j=0;j<n2;j++)
            R[j] = arr[mid+j+1];
        int i=0,j=0,k=l;
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while(i<n1)
        {
            arr[k++] = L[i++];
        }
        while(j<n2)
        {
            arr[k++] = R[j++];
        }
    }

    public static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {78,58,34,74,86,23,12,35,9};
        mergeSort(arr);
    }
}
