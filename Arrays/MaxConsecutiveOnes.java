/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.*/
package Arrays;
public class MaxConsecutiveOnes {
    public static int maxConsecutiveones(int[] nums,int k)
    {
        int count = 0;
        int j = -1;
        int len;
        int ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                count++;

            while(count > k)
            {
                j++;
                if(nums[j] == 0)
                    count--;
            }
            len = i-j;
            ans = Math.max(len,ans);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = { 1,1,0,1,0,0,1,1,0,1,1,1};
        int len = maxConsecutiveones(nums,2);
        System.out.println("Length of max consecutive ones in array : "+len);
    }
}
