package Arrays;

public class MinimumSwapsRequired {
    public static int countMinSwaps(int[] arr , int k)
    {
        int cnt = 0;
        for(int i: arr) {
            if(i<=k)
                ++cnt;
        }

        int smallerelementsthanK = 0;
        for(int i = 0; i < cnt ; i++) {
            if(arr[i] > k)
                smallerelementsthanK++;
        }
        int ans = smallerelementsthanK;
        for(int i = 0, j = cnt ; j<arr.length;i++,j++)
        {
            if(arr[i] > k)
                --smallerelementsthanK;
            if(arr[j] > k)
                ++smallerelementsthanK;

            ans = Math.min(smallerelementsthanK,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,3};
        int k = 3;
        System.out.println("Minimum swaps required to bring all elments less than k together is "+countMinSwaps(arr,k));
    }
}
