package Algorithms.Search;

import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCowsProblem {
    public static int minGap(int[] stalls, int n, int cows) {
        Arrays.sort(stalls);
        int high = n-1;
        int low = 0;
        int ans = 0;
        while(low <= high) {
            int mid = low + (high-low)/2 ;
            int cnt = 1 , left = 0;
            for(int i = 0;i < n && cnt < cows; i++) {
                if(stalls[i] - stalls[left] >= mid) {
                    left = i;
                    cnt++;
                }
            }
            if(cnt >= cows) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of stalls available in barn : ");
        int n = sc.nextInt();
        System.out.print("Enter no of cows needs to be accomodated : ");
        int cows = sc.nextInt();
        int[] stalls = new int[n];
        System.out.print("Enter stall gaps : ");
        for(int i = 0; i< n ; i++)
            stalls[i] = sc.nextInt();
        System.out.println("Minimum distance need to be maintained : "+minGap(stalls,n,cows));
    }
}
