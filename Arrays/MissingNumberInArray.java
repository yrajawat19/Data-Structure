package Arrays;
public class MissingNumberInArray {
    static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int sumtotal = n*(n+1)/2;
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        return sumtotal - sum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,6,7,8};
        int num = findMissingNumber(arr);
        System.out.println("The missing number in array is "+num);
    }
}
