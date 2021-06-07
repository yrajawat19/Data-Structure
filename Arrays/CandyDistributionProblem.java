/* Given an array A[] consisting of N integers, where each value represents the marks of the ith student, the task is to
 find the minimum number of chocolates required to be distributed such that:
1) Each student should be awarded with at least one chocolate
2) A student with higher marks should be awarded more chocolates than his adjacent students.*/
package Arrays;

public class CandyDistributionProblem {
    public static void main(String[] args) {
        int[] Test1 = {23, 14, 15, 14, 56, 29, 14}; // ans = 12
        int[] Test2 = {10,30,20}; //ans = 4
        System.out.println(" Minimum candies required for Test 1 : "+maxCandy(Test1)); // Test 1
        System.out.println("Minimum candies required for Test 2 : "+maxCandy(Test2)); // Test 2
    }
    static int maxCandy(int[] arr)
    {
        int[] dummy = new int[arr.length];
        int candiesRequired = 0;
        for(int i:dummy)
            i = 1;
        for(int i = 1;i<arr.length;i++)
        {
            if(arr[i-1]<arr[i])
                dummy[i] = dummy[i-1]+1;
            else
                dummy[i] = 1;
        }
        for(int i = arr.length-2;i>=0;i--)
        {
            if(arr[i+1]<arr[i])
                dummy[i] = Math.max(dummy[i],dummy[i+1]+1);
            else
                dummy[i] = Math.max(dummy[i],1);
        }
        for(int i:dummy)
            candiesRequired += i;

        return candiesRequired;
    }
}
