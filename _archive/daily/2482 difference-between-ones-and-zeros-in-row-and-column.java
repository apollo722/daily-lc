/*
https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/

统计每行/列的1的个数即可

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 2 * rows[i] + 2 * cols[j] - m - n;
            }
        }
        return res;
    }
}