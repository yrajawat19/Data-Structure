package Algorithms.Sort;

public class InsertionSort {
    static int[] insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++)
        {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && key<arr[j])
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
    static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {23,76,34,12,79,546,1221,1,12335464,654626,745,235457,76324,26573,4325,6476,342,6534,5,2345,362,4,767546,457,6584,5634,654,74,654,356,7,45,6344,756,74,634,5,34,765,85,46,3};
        System.out.println("Input Array :");
        printArray(arr);
        System.out.println("Array after Insertion sort : ");
        arr = insertionSort(arr);
        printArray(arr);
    }
}
