package Algorithms.Sort;

public class CountSort {
    public static int[] countSort(int[] arr)
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
            if(max<arr[i])
                max = arr[i];

        int count[] = new int[max+1];
        int output[] = new int[arr.length];

        for(int i=0;i<count.length;i++)
            count[i] = 0;

        for(int i=0;i<arr.length;i++)
            count[arr[i]]++;

        for(int i=1;i<count.length;i++)
            count[i] = count[i]+count[i-1];
        for(int i=arr.length-1;i>=0;i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return output;
    }

    public static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3,7,4,3,6,2,7,5,4,2,7,8,6};
        arr = countSort(arr);
        printArr(arr);
    }
}
