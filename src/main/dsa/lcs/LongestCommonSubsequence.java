package main.dsa.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int[][] mem = new int[1001][1001];
    static int[][] dp = new int[1001][1001];

    public int LongestCommonSubsequenceRecursive(String a, String b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + LongestCommonSubsequenceRecursive(a, b, m - 1, n - 1);
        return Math.max(LongestCommonSubsequenceRecursive(a, b, m - 1, n), LongestCommonSubsequenceRecursive(a, b, m, n - 1));
    }

    public int LongestCommonSubsequenceMemorization(String a, String b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (mem[m - 1][n - 1] != -1)
            return mem[m - 1][n - 1];
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            mem[m - 1][n - 1] = 1 + LongestCommonSubsequenceMemorization(a, b, m - 1, n - 1);
            return mem[m - 1][n - 1];
        }
        mem[m - 1][n - 1] = Math.max(LongestCommonSubsequenceMemorization(a, b, m - 1, n), LongestCommonSubsequenceMemorization(a, b, m, n - 1));
        return mem[m - 1][n - 1];
    }

    public int LongestCommonSubsequenceTopToBottom(String a, String b, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public String printLongestCommonSubsequence(String a, String b, int m, int n) {
        StringBuilder ans = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "qwerty";
        String b = "qhktwefbjrcgyty";
        int m = a.length();
        int n = b.length();

        for (int[] row : mem)
            Arrays.fill(row, -1);

        for (int[] row : dp)
            Arrays.fill(row, -1);

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.LongestCommonSubsequenceRecursive(a, b, m, n));
        System.out.println(lcs.LongestCommonSubsequenceMemorization(a, b, m, n));
        System.out.println(lcs.LongestCommonSubsequenceTopToBottom(a, b, m, n));
        System.out.println(lcs.printLongestCommonSubsequence(a, b, m, n));
    }
}