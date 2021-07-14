package Algorithms.BackTracking;
import java.util.*;
public class Subsets {
    // Driver code
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println("Subsets of input array : ");
        System.out.println(subsets(nums));
    }

    // Function to return list of subsets of array
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        GenerateSubsets(0,nums,new ArrayList<>(), subsets);
        return subsets;
    }

    // Function to recursively generate subsets
    private static void GenerateSubsets(int index , int[] nums , List<Integer> current , List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for(int i = index ; i < nums.length ; i++) {
            current.add(nums[i]);
            GenerateSubsets(i+1,nums,current,subsets);
            current.remove(current.size()-1);
        }
    }
}
