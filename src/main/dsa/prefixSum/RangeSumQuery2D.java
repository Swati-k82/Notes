package main.dsa.prefixSum;

import java.util.Arrays;
/*
https://leetcode.com/problems/range-sum-query-2d-immutable/
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
You must design an algorithm where sumRegion works on O(1) time complexity.


 */
public class RangeSumQuery2D {
    private int[][] sum;
    public RangeSumQuery2D(int[][] matrix) {
        int m = matrix.length, n= matrix[0].length;
        sum = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(sum[i], 0);
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sum[i][j]= sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return sum[row2][col2] -sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
    }

    public static void  main(String[] args) {
        RangeSumQuery2D solution = new RangeSumQuery2D(new int[][]{{1, 2, 3, 4},
               {5, 6, 7, 8},
              {9, 10, 11, 12}});

        assert solution.sumRegion(0, 0, 1, 1) == 14 : "Test Case 1.1 Failed";
        assert solution.sumRegion(1, 1, 2, 2) == 34 : "Test Case 1.2 Failed";
        assert solution.sumRegion(0, 0, 2, 3) == 78 : "Test Case 1.3 Failed";

        // Test Case 2: Single row
        int[][] matrix2 = {
                {1, 2, 3, 4}
        };
        RangeSumQuery2D numMatrix2 = new RangeSumQuery2D(matrix2);
        assert numMatrix2.sumRegion(0, 0, 0, 3) == 10 : "Test Case 2.1 Failed";
        assert numMatrix2.sumRegion(0, 1, 0, 2) == 5 : "Test Case 2.2 Failed";

        // Test Case 3: Single column
        int[][] matrix3 = {
                {1},
                {2},
                {3},
                {4}
        };
        RangeSumQuery2D numMatrix3 = new RangeSumQuery2D(matrix3);
        assert numMatrix3.sumRegion(0, 0, 3, 0) == 10 : "Test Case 3.1 Failed";
        assert numMatrix3.sumRegion(1, 0, 2, 0) == 5 : "Test Case 3.2 Failed";

        // Test Case 4: Single element
        int[][] matrix4 = {
                {42}
        };
        RangeSumQuery2D numMatrix4 = new RangeSumQuery2D(matrix4);
        assert numMatrix4.sumRegion(0, 0, 0, 0) == 42 : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
