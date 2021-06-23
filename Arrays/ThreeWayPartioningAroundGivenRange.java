package Arrays;

public class ThreeWayPartioningAroundGivenRange {
    public static void swap(int[] arr, int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void ThreeWayPartition(int[] arr , int lowValue , int highValue)
    {
        int start = 0;
        int end = arr.length - 1;

        for(int i = 0; i <= end;)
        {
            if(arr[i]< lowValue) {
                swap(arr, i, start);
                start++;
                i++;
            }
            else if(arr[i] > highValue) {
                swap(arr , i ,end);
                end--;
            }
            else
                i++;
        }
    }
    public static void print(int[] arr)
    {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int lowValue = 10;
        int highValue = 20;
        System.out.println("Input array : ");
        print(arr);
        ThreeWayPartition(arr,lowValue,highValue);
        System.out.println("Array after 3 way partition : ");
        print(arr);

    }
}
