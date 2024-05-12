/*
https://leetcode.com/problems/largest-local-values-in-a-matrix/

代码题

Time: O(n^2)
Space: O(1)
*/

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        res[i][j] = Math.max(res[i][j], grid[r][c]);
                    }
                }
            }
        }
        return res;
    }
}