package Arrays;

public class shiftNegativeElement2Left {
    public static void swap(int arr[],int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void shiftAll(int[] arr) {
        int j = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                if(i != j)
                {
                    swap(arr,i,j);
                }
                j++;
            }
        }
        printArr(arr);

    }
    public static void printArr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {5,-2,-3,1,3,4,-4,6,4,3,7,8,9,-7,-9,-10};
        printArr(arr);
        shiftAll(arr);
    }
}
