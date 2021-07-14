package Algorithms.BackTracking;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7 ;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates,combinations,new ArrayList<>());
        return combinations;
    }
    // Function to find combinations and store them in list .
    public static void backtrack(int index,int rem,int[] nums , List<List<Integer>> combinations , List<Integer> current) {
        if(rem < 0)
            return ;
        else if(rem == 0)
            combinations.add(new ArrayList<Integer>(current));
        else {
            for(int i = index; i <nums.length; i++) {
                current.add(nums[i]);
                backtrack(i,rem-nums[i],nums,combinations,current);
                current.remove(current.size()-1);
            }
        }
    }
}
