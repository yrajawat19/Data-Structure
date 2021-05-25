package Algorithms.Sort;

public class Merge{
    public static void main(String[] args) {
        int a[] = {12,24,36,48,60,72,84,96,108,120};
        int b[] = {13,26,39,52,65,78,91,104,117,130};
        merger(a,b);
    }
    // Merge algorithm for 2 shorted list.
    private static void merger(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        int c[] = new int[m+n];
        int k=0,j=0,i=0;
        while(i<n && j<m) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        while(i<n)
            c[k++] = a[i++];
        while(j<m)
            c[k++] = b[j++];

        printArr(c);
    }
    // printArr method to print given array
    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
