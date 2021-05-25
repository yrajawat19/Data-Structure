package Algorithms.Sort;

public class RadixSort {
    public static void radixSort(int[] arr)
    {
        int size = arr.length;
        int max = getMax(arr,size);
        for(int place = 1; max/place >0;place*=10)
            countingSort(arr,place);
        printArr(arr);
    }

    private static void countingSort(int[] arr, int place) {
        int[] output = new int[arr.length];
        int max = arr[0];
        for(int i=1;i<arr.length;i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int[] count = new int[max+1];
        for(int i=0;i<max;i++)
            count[i] = 0;
        for(int i=0;i<arr.length;i++)
            count[(arr[i]/place)%10]++;
        for(int i=1;i<10;i++)
            count[i] = count[i]+count[i-1];
        for(int i=arr.length-1;i>=0;i--)
        {
            output[count[(arr[i]/place)%10]-1] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        for(int i=0;i<arr.length;i++)
            arr[i] = output[i];
    }

    static int getMax(int[] arr, int size)
    {
        int max = arr[0];
        for(int i=1;i<size;i++)
            if(max<arr[i])
                max = arr[i];
            return max;
    }

    public static void main(String[] args) {
        int[] arr = {123,65,86,2,753,975,9,23465,345,6845,345,6774};
        radixSort(arr);

    }

    private static void printArr(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
