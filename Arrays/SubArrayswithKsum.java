package Arrays;

import java.util.HashMap;

public class SubArrayswithKsum {
    private static int findSubArrays(int[] nums, int k)
    {
        int i = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        if(n == 0)
            return 0;
        while(i<n)
        {
            sum += nums[i];
            if(sum == k)
                count++;
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test1 = {3,4,7,2,3,-5,2,5,};
        int[] test2 = {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        System.out.println("Test 1 "+findSubArrays(test1,7));
        System.out.println("Test 2 "+findSubArrays(test2,5));
    }
}
