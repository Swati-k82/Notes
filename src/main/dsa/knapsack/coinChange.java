package main.dsa.knapsack;

import java.util.Arrays;

/*
Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
*/
public class coinChange {
    static int[][] mem = new int[1001][1001];
    static int[][] dp = new int[1001][1001];

    public int coinChangeRecursive(int[] coins, int n, int amount) {
        if (amount == 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1;

//        if (n == 1) {
//            if (amount % coins[0] == 0)
//                return amount / coins[0];
//            else
//                return Integer.MAX_VALUE - 1;
//        }
        if (coins[n - 1] <= amount)
            return Math.min(1 + coinChangeRecursive(coins, n, amount - coins[n - 1]), coinChangeRecursive(coins, n - 1, amount));
        else
            return coinChangeRecursive(coins, n - 1, amount);
    }

    public int coinChangeMemorization(int[] coins, int n, int amount) {
        if (amount == 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1;
        if (mem[n][amount] != -1)
            return mem[n][amount];
//        if (n == 1) {
//            if (amount % coins[0] == 0)
//                return amount / coins[0];
//            else
//                return Integer.MAX_VALUE - 1;
//        }
        if (coins[n - 1] <= amount)
            mem[n][amount] = Math.min(1 + coinChangeMemorization(coins, n, amount - coins[n - 1]), coinChangeMemorization(coins, n - 1, amount));

        else
            mem[n][amount] = coinChangeMemorization(coins, n - 1, amount);
        return mem[n][amount];
    }

    public int coinChangeTabular(int[] coins, int n, int amount) {
        // row - coin size
        // col - amount
        for (int j = 0; j <= amount; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[1][j] = j / coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        if (dp[n][amount] != Integer.MAX_VALUE - 1)
            return dp[n][amount];
        else
            return -1;

    }

    public static void main(String[] args) {
        int[] coins = {1,2,3,5,7};
        int n = coins.length;
        int amount = 50;
        for (int[] row : mem)
            Arrays.fill(row, -1);

        for (int[] row : dp)
            Arrays.fill(row, -1);

        coinChange obj = new coinChange();
        System.out.println(obj.coinChangeRecursive(coins, n, amount));
        System.out.println(obj.coinChangeMemorization(coins, n, amount));
        System.out.println(obj.coinChangeTabular(coins, n, amount));

        for (int i = 0; i <= n; i++){
            System.out.println();
            for (int j = 0; j <= amount; j++)
                System.out.print(dp[i][j] + " ");
        }
    }
}
