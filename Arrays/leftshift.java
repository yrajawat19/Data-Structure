package Arrays;

public class leftshift {
    public static void LeftShift(int[] arr, int k)
    {
        int n = arr.length;
        int i=0;
        int[] temp = new int[k+1];
        for(int j=0;j<k;j++)
        {
            temp[j] = arr[j];
        }
        for( i = 0;i<n-k;i++)
        {
            arr[i] = arr[i+k];
        }
        while(i<n)
        {
            for(int j=0;j<k;j++)
            arr[i++] = temp[j];
        }
       printArr(arr);
    }

    public static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,23,45,66};
        printArr(arr);
        int k = 3;
        LeftShift(arr,k);
    }
}
