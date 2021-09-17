/* Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.*/

package Algorithms.BackTracking;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range : ");
        int n = sc.nextInt();
        System.out.print("Enter size : ");
        int k = sc.nextInt();
        System.out.println(combine(n,k));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(result,n,k,1,new ArrayList<>());
        return result ;
    }

    public static void combinations(List<List<Integer>> result , int n , int k , int index , List<Integer> current) {
        if(k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i<=n ; i++) {
            current.add(i);
            combinations(result,n,k-1,i+1,current);
            current.remove(current.size()-1);
        }
    }
}
