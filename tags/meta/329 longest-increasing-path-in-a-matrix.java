/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

DFS模板
需要用memo来存储计算过的位置，以代替visited的功能
存储计算过的cell也加速了整体计算

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    int[] dir = {-1, 0, 1, 0, -1};
    private int dfs(int[][] matrix, int r, int c) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        if (memo[r][c] != 0) return memo[r][c];
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + r, j = dir[d + 1] + c;
            if (i >= 0 && i < m && j >= 0 && j < n && matrix[r][c] < matrix[i][j]) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        
        res++;
        memo[r][c] = res;
        return res;
    }
}