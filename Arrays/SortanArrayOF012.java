package Arrays;

public class SortanArrayOF012 {
    static void sort012(int[] a)
    {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        for(int j=0;j<a.length;j++)
        {
            switch(a[j])
            {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }
        while(count0>0)
        {
            a[i++]= 0;
            count0--;
        }
        while(count1 > 0)
        {
            a[i++] = 1;
            count1--;
        }
        while(count2 > 0)
        {
            a[i++] =2;
            count2--;
        }
        printArr(a);
    }
    public static void printArr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,1,0,2,1,2,0,0,2,1};
        printArr(arr);
        sort012(arr);
    }
}
