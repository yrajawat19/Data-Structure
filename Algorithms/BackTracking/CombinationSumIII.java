/* Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations.

The list must not contain the same combination twice, and the combinations may be returned in any order.*/
package Algorithms.BackTracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.print("Enter number(1-9) : ");
        int num = new Scanner(System.in).nextInt();
        System.out.print("Enter target : ");
        int target = new Scanner(System.in).nextInt();
        System.out.println(combinationSum3(num,target));
    }
    // Function to return list of combinations with total sum equal to target .
    public static List<List<Integer>> combinationSum3(int k,int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(1,k,n,combinations,new ArrayList<Integer>());
        return combinations;
    }

    public static void backtrack(int start , int size , int rem , List<List<Integer>> combinations , ArrayList<Integer> current) {
        if(rem < 0)
            return;
        else if(rem == 0 && current.size() == size)
            combinations.add(new ArrayList<>(current));
        else {
            for(int i = start ; i<10; i++) {
                current.add(i);
                backtrack(i+1,size,rem-i,combinations,current);
                current.remove(current.size()-1);
            }
        }
    }
    }

