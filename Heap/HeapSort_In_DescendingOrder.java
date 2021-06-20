package Heap;

class HeapsortDESC
{
    // This method returns leftchild position for given position .
    int leftChild(int pos) {
        return (2*pos)+1;
    }
    // This method returns right child position for given position .
    int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    public void minHeapify(int pos,int size,int arr[])
    {
        if(leftChild(pos)<size && arr[pos]>arr[leftChild(pos)])
        {
            int swap = arr[pos];
            arr[pos] = arr[leftChild(pos)];
            arr[leftChild(pos)] = swap;
            minHeapify(leftChild(pos),size,arr);
        }
        if(rightChild(pos)<size && arr[pos]>arr[rightChild(pos)])
        {
            int swap = arr[pos];
            arr[pos] = arr[rightChild(pos)];
            arr[rightChild(pos)] = swap;
            minHeapify(rightChild(pos),size,arr);
        }
    }

    public void sort(int arr[])
    {
        int size = arr.length;
        for(int i=size/2-1;i>=0;i--)
            minHeapify(i,size,arr);
        for(int i=size-1;i>=0;i--) {
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;
            minHeapify(0,i,arr);
        }
    }

    public void print(int[] arr)
    {
        int size = arr.length;
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
public class HeapSort_In_DescendingOrder {
    public static void main(String[] args) {
      HeapsortDESC h = new HeapsortDESC();
      int arr[] = {12,34,65,87,6,67,8};
      h.sort(arr);
      h.print(arr);

    }
}
