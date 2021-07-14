/* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.*/
package Algorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PermutationsII {
    // Driver code
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println("All permutations of input array : ");
        System.out.println(permuteUnique(nums));
    }

    // Function to return list of unique permutations .
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        GeneratePermutations(nums, permutations, new ArrayList<>(), new boolean[nums.length]);
        return permutations;
    }

    // recursive function to generate permutations and store in arraylist .
    private static void GeneratePermutations(int[] nums, List<List<Integer>> permutations, ArrayList<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                current.add(nums[i]);
                GeneratePermutations(nums, permutations, current, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
