class Solution {
    int m, n;
    int[] dir = {-1, 0, 1, 0, -1};
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memo = new int[this.m][this.n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                res = Math.max(calc(matrix, i, j), res);
            }
        }
        return res;
    }

    private int calc(int[][] matrix, int r, int c) {
        if (memo[r][c] > 0) return memo[r][c];
        int res = 0;
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + r, j = dir[d + 1] + c;
            if (i < m && i >= 0 && j < n && j >= 0 && matrix[r][c] < matrix[i][j]) {
                res = Math.max(res, calc(matrix, i, j));
            }
        }
        res++;
        memo[r][c] = res;
        return res;
    }
}