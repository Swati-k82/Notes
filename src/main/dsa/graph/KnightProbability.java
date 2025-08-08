package main.dsa.graph;

/*
There is a knight on an n x n chessboard. In a valid configuration, the knight starts at the top-left cell of the board and visits every cell on the board exactly once.

You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1]
where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.

Return true if grid represents a valid configuration of the knight's movements or false otherwise.

Note that a valid knight move consists of moving two squares vertically and one square horizontally, or two squares horizontally and one square vertically.
The figure below illustrates all the possible eight moves of a knight from some cell.

Input: grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
Output: true
Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.

 */

public class KnightProbability {
    int row[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    int col[] = {1, 2, 2, 1, -1, -2, -2, -1};
    public boolean checkValidGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]!=0)
            return false;
        return checkReursively(grid, m, n, 0 , 0, 0, (m*n)-1);
    }
    public boolean checkReursively(int[][] grid, int m, int n, int i, int j, int currVal, int target){

        if(currVal==target)
            return true;

        for( int k = 0 ; k<8 ; k++){
            int nr = i + row[k];
            int nc = j + col[k];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc]==currVal+1)
                if (checkReursively(grid, m, n, nr , nc, currVal+1, target))
                    return true;
        }

        return false;
    }

    public static void main(String[] args) {
//int[][] grid = {
//        [0, 59, 38, 33, 30, 17, 8, 63],
//    [37, 34, 31, 60, 9, 62, 29, 16],
//    [58, 1, 36, 39, 32, 27, 18, 7],
//    [35, 48, 41, 26, 61, 10, 15, 28],
//    [42, 57, 2, 49, 40, 23, 6, 19],
//    [47, 50, 45, 54, 25, 20, 11, 14],
//    [56, 43, 52, 3, 22, 13, 24, 5],
//    [51, 46, 55, 44, 53, 4, 21, 12]
//}
  };
}
