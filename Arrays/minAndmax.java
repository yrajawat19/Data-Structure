package Arrays;

public class minAndmax {
    static class pair {
        int min;
        int max;
    }
    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    static pair minMax(int[] arr)
    {
        pair minmax = new pair();
        int n = arr.length;
        if(n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }
            if(arr[0]>arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            }
            else  {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
        for(int i=2;i<n;i++)
        {
            if(arr[i] < minmax.min)
                minmax.min = arr[i];
            else if(arr[i] > minmax.max)
                minmax.max = arr[i];
        }

        return minmax;

    }

    public static void main(String[] args) {
        int arr[] = {12,4,5,6,7,2,5,2,676,345,765,45,68,63,547,54,54367,86,4,6,786,4};
        printArr(arr);
        pair minmax = minMax(arr);
        System.out.println("Minimum element in array : "+minmax.min);
        System.out.println("Maximum element in array : "+minmax.max);

    }
}
