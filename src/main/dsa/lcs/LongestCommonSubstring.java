package main.dsa.lcs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstring {
    static Map<String, Integer> mem = new HashMap<String, Integer>();
    static int[][] dp = new int[1001][1001];
    int row = 0, col = 0;

    public int LongestCommonSubstringRecursive(String a, String b, int m, int n, int currRes) {
        if (m == 0 || n == 0) return 0;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            currRes = 1 + LongestCommonSubstringRecursive(a, b, m - 1, n - 1, currRes);
        return Math.max(currRes, Math.max(LongestCommonSubstringRecursive(a, b, m, n - 1, 0), LongestCommonSubstringRecursive(a, b, m - 1, n, 0)));
    }

    public int LongestCommonSubstringMemorization(String a, String b, int m, int n, int currRes) {
        if (m == 0 || n == 0) return 0;

        String key = m + "," + n + "," + currRes;
        if (mem.containsKey(key)) return mem.get(key);

        if (a.charAt(m - 1) == b.charAt(n - 1))
            currRes = 1 + LongestCommonSubstringMemorization(a, b, m - 1, n - 1, currRes);

        mem.put(key, Math.max(currRes, Math.max(LongestCommonSubstringMemorization(a, b, m, n - 1, 0), LongestCommonSubstringMemorization(a, b, m - 1, n, 0))));
        return mem.get(key);
    }

    public int LongestCommonSubstringTopToBottom(String a, String b, int m, int n) {
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = 0;
                if (dp[i][j] > ans) {
                    ans = dp[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return ans;
    }

    public String printLongestCommonSubstring(String a, String b, int m, int n) {
        StringBuilder ans = new StringBuilder();
        int i = row, j = col;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "aaasubstringiiii";
        String b = "uuuuuuuuuusubstringllllll";
        int m = a.length();
        int n = b.length();

        for (int[] row : dp)
            Arrays.fill(row, -1);

        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.LongestCommonSubstringRecursive(a, b, m, n, 0));
        System.out.println(lcs.LongestCommonSubstringMemorization(a, b, m, n, 0));
        System.out.println(lcs.LongestCommonSubstringTopToBottom(a, b, m, n));
        System.out.println(lcs.printLongestCommonSubstring(a, b, a.length(), b.length()));
    }
}
