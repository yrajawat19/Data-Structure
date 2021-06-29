package Algorithms.DP;

public class SubsetSumProblem {
    // Function to find whether subset exist or not with total sum equal to target .
    public static boolean isSubset(int[] set , int n , int target) {
        boolean[][] table = new boolean[n+1][target+1];

        for(int i = 0; i<= n ; i++) {
            for(int j = 0; j<= target ; j++) {

                if(i == 0 && j == 0)
                    table[i][j] = true; // when target sum and set both are null , then it is true .
                else if(i == 0 && j != 0)
                    table[i][j] = false; // when target sum is not null but set is null , then it is false.
                else if(i != 0 && j == 0)
                    table[i][j] = true; // when target sum is null and set is not null , then it is possible to achieve target sum by excluding all subsets .
                else if(set[i-1] <= j) /// when sum is greater or equal to element in set .
                    table[i][j] = table[i-1][j] || table[i-1][j-set[i-1]]; // we check by including and excluding the element from subset whether it is possible or not .
                else
                    table[i][j] = table[i-1][j]; // when element is greater than target sum , we must exclude this element .
            }
        }
        return table[n][target]; // return final value .
    }
    // Driver code
    public static void main(String[] args) {
        int[] set = { 3, 34, 4, 12, 5, 2 }; // set of elements
        int sum = 30; // target sum
        if(isSubset(set,set.length,sum))
            System.out.println("True . ");
        else
            System.out.println("False . ");
    }
}
