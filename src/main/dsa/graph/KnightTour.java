package main.dsa.graph;
/*
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0),
                               and the bottom-right cell is (n - 1, n - 1).
A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
The knight continues moving until it has made exactly k moves or has moved off the chessboard.
Return the probability that the knight remains on the board after it has stopped moving.

Example 1:

Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Example 2:

Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
*/

/* Solution:
Traverse using dfs, if we go out of the board, return 0.
If we reach to the k moves, return 1.
 Use memoization to store the result of each state.
 The key is the current position of the knight and the number of moves left.

*/

import java.util.HashMap;
import java.util.Map;

public class KnightTour {
    int[] dr = {-2, 2, -1, 1, 1, -1, 2, -2};
    int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};

    public double knightProbability(int n, int k, int row, int col) {
        Map<String, Double> mem = new HashMap<String, Double>();
        return check(n, k, row, col, mem);
    }

    public double check(int n, int k, int i, int j, Map<String, Double> mem) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;

        if (k == 0)
            return 1;

        String key = i + "abc" + j + "xyz" + k;
        if (mem.containsKey(key))
            return mem.get(key);

        double p = 0;
        for (int x = 0; x < 8; x++) {
            int nr = i + dr[x];
            int nc = j + dc[x];

            p += (check(n, k - 1, nr, nc, mem)) / 8.0;

        }
        mem.put(key, p);
        return mem.get(key);
    }

    public static void main(String[] args) {

    }
}
