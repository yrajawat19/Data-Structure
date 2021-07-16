package Algorithms.Sort;

public class HeapSort {
    // Driver code
    public static void main(String[] args) {
        int[] nums = {12,35,56,2,6,4,3,8,5,9,13,15,16,191};
        System.out.println("Input array : ");
        print(nums);
        System.out.println("Sorted array : ");
        heapsort(nums);
        print(nums);
    }
    // Function to print array
    private static void print(int[] nums) {
        for(int num : nums)
            System.out.print(num+" ");
        System.out.println();
    }
    // Function to heap sort the array .
    private static void heapsort(int[] nums) {
        int size = nums.length;
        for(int i = size/2-1;i>=0;i--)
            heapify(i,size,nums);
        for(int i = size-1; i>=0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(0,i,nums);
        }
    }

    private static void heapify(int i , int size , int[] nums) {
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;

        if(leftChild<size && nums[leftChild] > nums[largest])
            largest = leftChild;
        if(rightChild < size && nums[rightChild] > nums[largest])
            largest = rightChild;

        if(largest != i) {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapify(largest,size,nums);
        }
    }
}
