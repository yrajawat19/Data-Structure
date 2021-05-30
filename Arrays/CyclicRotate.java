package Arrays;

public class CyclicRotate {
    public static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void cyclicRotate(int[] arr,int k)
    {
        int[] dummy = new int[k];
        int j =0;
        for(int i = arr.length-1;i>k+1;i--)
            dummy[j++] = arr[i];
        printArr(dummy);
        for(int i=arr.length-1;i>=k;i--) {

            arr[i] = arr[i-k];
        }
        for(int i=0;i<k;i++)
            arr[i] = dummy[i];

        printArr(arr);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 2;
        cyclicRotate(arr,k);
    }
}
