package main.dsa.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubset {
    static boolean[][] dp = new boolean[1001][1001];
    static boolean[][] mem = new boolean[1001][1001];

    private boolean subSetsumRecursive(int[] nums, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (nums[n - 1] <= sum)
            return subSetsumRecursive(nums, n - 1, sum - nums[n - 1]) || subSetsumRecursive(nums, n - 1, sum);
        return subSetsumRecursive(nums, n - 1, sum);
    }

    private boolean subSetsumMemorization(int[] nums, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (mem[n][sum]) return mem[n][sum];
        if (nums[n - 1] <= sum)
            mem[n][sum] = subSetsumMemorization(nums, n - 1, sum - nums[n - 1]) || subSetsumMemorization(nums, n - 1, sum);
        else mem[n][sum] = subSetsumMemorization(nums, n - 1, sum);
        return mem[n][sum];
    }

    private boolean subSetsumTabular(int[] nums, int n, int sum) {
        System.out.println(sum);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
            dp[0][i] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    private void printSubset(int[] nums, int n, int sum) {
        List<Integer> subSet = new ArrayList<Integer>();
        int i = n, j = sum;
        while (i > 0 && j > 0) {
            if (!dp[i - 1][j]) {
                subSet.add(nums[i - 1]);
                i--;
                j -= nums[i - 1];
            } else {
                i--;
            }
        }
        System.out.println("First Subset");
        for (Integer ele : subSet) {
            System.out.print(ele + " ");
        }
        List<Integer> subSet2 = new ArrayList<Integer>();
        for (i = 0; i < n; i++) {
            if (!subSet.contains(nums[i])) subSet2.add(nums[i]);
            else subSet.remove(subSet.indexOf(nums[i]));
        }
        System.out.println();
        System.out.println("Second Subset");
        for (Integer ele : subSet2) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 2};
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];

        for (boolean[] row : dp)
            Arrays.fill(row, false);

        for (boolean[] row : mem)
            Arrays.fill(row, false);

        if (sum % 2 != 0) System.out.println(false);
        else {
            PartitionEqualSubset obj = new PartitionEqualSubset();
            System.out.println(obj.subSetsumRecursive(nums, n, sum / 2));
            System.out.println(obj.subSetsumMemorization(nums, n, sum / 2));
            System.out.println(obj.subSetsumTabular(nums, n, sum / 2));

//            //print table
//            for (int i = 0; i <= n; i++) {
//                for (int j = 0; j <= sum; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

            if (dp[n][sum / 2]) obj.printSubset(nums, n, sum / 2);
        }
    }
}
