package Arrays;
public class Minimize_the_difference {
    static class Pair {
        int min;
        int max;
    }
    public static void main(String[] args) {
        int[] arr = {1, 10, 14, 14, 14, 15};
        int k = 6;
        System.out.println("Array before height change :");
        print(arr);
        arr = minmize(arr,k);
        System.out.println("Array after height change :");
        print(arr);
        Pair minmax = minMax(arr);
        int difference = minmax.max - minmax.min;
        System.out.println("Maximum difference : "+difference);

    }

    static Pair minMax(int[] arr)
    {
        Pair minmax = new Pair();
        int n = arr.length;
        if(n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }
        if(arr[0]>arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        }
        else  {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }
        for(int i=2;i<n;i++)
        {
            if(arr[i] < minmax.min)
                minmax.min = arr[i];
            else if(arr[i] > minmax.max)
                minmax.max = arr[i];
        }

        return minmax;

    }
    static void print(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private static int[] minmize(int[] arr,int k) {
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i]>k)
                arr[i] = arr[i] - k;
            else if(arr[i]<= k)
                arr[i] = arr[i] + k;
        }
        return arr;
    }
}
