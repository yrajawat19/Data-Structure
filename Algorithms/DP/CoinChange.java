package Algorithms.DP;

import java.util.Scanner;

public class CoinChange {
    private static int minimumCoins(int[] coins , int amount )
    {
        int[] table = new int[amount+1];
        table[0] = 0;
        for(int i = 1;i <= amount ; i++)
            table[i] = Integer.MAX_VALUE;

        for(int i = 1 ; i <= amount ; i++)
        {
            for (int coin : coins) {
                if (coin <= i) {
                    int subresult = table[i - coin];
                    if (subresult != Integer.MAX_VALUE && subresult + 1 < table[i])
                        table[i] = subresult+1;
                }
            }
        }

        if(table[amount] == Integer.MAX_VALUE)
            return -1;

        return table[amount];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of coins ");
        int m = sc.nextInt();
        int[] coins = new int[m];
        System.out.println("Enter coins value : ");
        for(int i = 0 ; i < m ; i++)
            coins[i] = sc.nextInt();
        System.out.println("Enter amount : ");
        int amount = sc.nextInt();

        System.out.println("Minimum coins needed "+minimumCoins(coins,amount));
    }
}