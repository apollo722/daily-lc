/*
https://leetcode.com/problems/01-matrix/

DP模板，从头尾分别扫描

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) res[i][j] = Integer.MAX_VALUE - 10000;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                }
                if (j > 0) {
                    res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }
        return res;
    }
}