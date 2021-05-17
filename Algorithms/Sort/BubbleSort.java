package Algorithms.Sort;

public class BubbleSort {
    static void swap(int a,int b,Integer[] arr)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static Integer[] bubbleSort(Integer[] arr) {
        int size = arr.length;
        for(int i=0;i<size;i++)
        {
            for(int j=i+1;j<size;j++)
                if(arr[i]>arr[j])
                    swap(i,j,arr);
        }
        return arr;
    }
    static void printArray(Integer[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] arr = {23,76,34,12,79,546,1221,1,12335464,654626,745,235457,76324,26573,4325,6476,342,6534,5,2345,362,4,767546,457,6584,5634,654,74,654,356,7,45,6344,756,74,634,5,34,765,85,46,3};
        System.out.println("Input Array :");
        printArray(arr);
        System.out.println("Array after Bubble sort : ");
        arr = bubbleSort(arr);
        printArray(arr);

    }
}
