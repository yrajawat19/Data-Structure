/*There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to the sum of their lengths. We need to connect the ropes with minimum cost.*/
package Heap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostToConnectNRopes {
    public static int minCost(int[] len , int n)
    {
        PriorityQueue<Integer> q = new PriorityQueue(); // Priority Queue .
        for(int i: len)
            q.add(i); // Adding all lengths in priority queue .
        int cost = 0 ; // Cost of connecting of all ropes .
        while(q.size() > 1) { // while size is greater than one element .
            int first_min = q.poll(); // Extract first minimum element .
            int second_min = q.poll(); // Extract second minimum element .
            cost += first_min + second_min ; // Cost of joining ropes .
            q.add(first_min + second_min); // Pushing back joined ropes length in priority queue .
        }

        return cost;
    }
    public static void main(String[] args) {
        System.out.print("Enter no of ropes : "); // Asking for user's input for total number of ropes .
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Taking user's input for number of ropes .
        int[] len = new int[n]; // Array to store length of all ropes .
        System.out.print("Enter lengths of ropes : "); // Asking for all ropes length .
        for(int i = 0 ; i < n ; i++)
            len[i] = sc.nextInt();

        System.out.println("Minimum cost required to connect all ropes : "+minCost(len,n)); // Printing minimum cost required .
    }
}