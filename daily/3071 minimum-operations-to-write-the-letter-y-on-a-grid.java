/*
https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/

统计字母Y和非字母Y位置的频率
找到频率组合（即值不相等的取法）和的最大值，剩下的部分都要改成组合中的值
即n*n-max

Time: O(n^2)
Space: O(1)
*/

class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] m = new int[3], y = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isY(n, i, j)) {
                    y[grid[i][j]]++;
                } else m[grid[i][j]]++; 
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    max = Math.max(max, y[i] + m[j]);
                }
            }
        }
        return n * n - max;
    }

    private boolean isY(int n, int i, int j) {
        if ((i == j && i <= n / 2 && j <= n / 2) || 
        (i + j == n - 1 && i <= n / 2 && j >= n / 2) || 
        (i > n / 2 && j == n / 2)) return true;
        return false;
    }
}