package main.dsa.lcs;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    static  int[][] dp = new int[1001][1001];
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        for(int[] row: dp)
            Arrays.fill(row, -1);

        for(int i =0;i<=n;i++){
            dp[0][i]=0;
            dp[i][0]=0;
        }

        String s1 = new StringBuilder(s).reverse().toString();
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s1.charAt(j-1))
                    dp[i][j]=1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    public String print(String a, String b, int m, int n) {
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
        String a = "bbbab";

        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromeSubseq(a));
        System.out.println(lps.print(a,new StringBuilder(a).reverse().toString(),a.length(),a.length()));
    }
}
