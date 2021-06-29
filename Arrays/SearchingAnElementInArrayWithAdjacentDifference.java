package Arrays;

public class SearchingAnElementInArrayWithAdjacentDifference {
    public static int SearchElement(int[] arr , int k , int x)
    {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] == x)
                return i;

            i += Math.max(1,Math.abs(arr[i] - x)/k);
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 7, 7, 6};
        int k = 2;
        int x = 6;
        System.out.println("Position of "+x+" in array is "+SearchElement(arr,k,x));
    }
}
