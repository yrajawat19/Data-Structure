package Heap;
import java.util.*;
class heapSort
{
    public void heapify(int i,int size, int arr[])
    {
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        if(leftChild<size && arr[largest]<arr[leftChild])
            largest = leftChild;
        if(rightChild<size && arr[largest]<arr[rightChild])
            largest = rightChild;

        if(largest != i)
        {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;

            heapify(largest,size,arr);
        }

    }

    public void heapsort(int arr[])
    {
        int size = arr.length;
        // Build heap
        for(int i=size/2-1;i>=0;i--)
            heapify(i,size,arr);
        for(int i=size-1;i>=0;i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //heapify root element
            heapify(0,i,arr);
        }
    }

    public void print(int arr[])
    {
        int size = arr.length;
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }
}
public class HeapSort_In_AscendingOrder
{
    public static void main (String[] args) {
        heapSort h = new heapSort();
        int[] arr = {12,35,56,2,6,4,3,8,5,9,13,15,16,191};
        h.heapsort(arr);
        System.out.println("Sorted array :");
        h.print(arr);

    }
}