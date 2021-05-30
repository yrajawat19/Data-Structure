package Arrays;

public class arrayReverse {
    static void reverseArr(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start<end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        printArr(arr);
    }
    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {12,24,36,48,60,72,84,96,108,120};
        printArr(arr);
        reverseArr(arr);
    }
}
