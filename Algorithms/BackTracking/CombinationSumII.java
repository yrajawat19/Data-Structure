/* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations. */
package Algorithms.BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(0,target,combinations,new ArrayList<>(),candidates);
        return combinations;
    }
    // Recursive function to find combinations and store them in array list .
    public static void generateCombinations(int start,int rem,List<List<Integer>> combinations,ArrayList<Integer> current , int[] candidates) {
        if(rem < 0)
            return;
        else if(rem == 0)
            combinations.add(new ArrayList<>(current));
        else {
            for(int i = start ; i < candidates.length ; i++) {
                if(i > start && candidates[i] == candidates[i-1])
                    continue; // if duplicates,skip
                current.add(candidates[i]);
                generateCombinations(i+1,rem-candidates[i],combinations,current,candidates);
                current.remove(current.size()-1);
            }
        }
    }
}
