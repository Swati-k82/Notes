package main.dsa.knapsack;
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/

import java.util.Arrays;

public class coinChangeII {
    static int[][] mem = new int[1001][1001];
    static int[][] dp = new int[1001][1001];

    public int coinChangeRecursive(int[] coins, int n, int amount) {
        if (amount == 0) return 1;
        if (n == 0) return 0;
        if (coins[n - 1] <= amount)
            return coinChangeRecursive(coins, n, amount - coins[n - 1]) + coinChangeRecursive(coins, n - 1, amount);
        else return coinChangeRecursive(coins, n - 1, amount);
    }

    public int coinChangeMemorization(int[] coins, int n, int amount) {
        if (amount == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][amount] != -1) return dp[n][amount];
        if (coins[n - 1] <= amount)
            dp[n][amount] = coinChangeMemorization(coins, n, amount - coins[n - 1]) + coinChangeMemorization(coins, n - 1, amount);
        else dp[n][amount] = coinChangeMemorization(coins, n - 1, amount);
        return dp[n][amount];
    }

    public int coinChangeTabular(int[] coins, int n, int amount) {
        dp = new int[n + 1][amount + 1];

        for (int j = 0; j <= amount; j++)
            dp[0][j] = 0;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int n = coins.length;
        int amount = 11;

        for (int[] row : mem)
            Arrays.fill(row, -1);

        for (int[] row : dp)
            Arrays.fill(row, -1);


        coinChangeII obj = new coinChangeII();
        System.out.println(obj.coinChangeRecursive(coins, n, amount));
        System.out.println(obj.coinChangeMemorization(coins, n, amount));
        System.out.println(obj.coinChangeTabular(coins, n, amount));

    }


}

