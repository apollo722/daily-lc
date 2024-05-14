/*
https://leetcode.com/problems/score-after-flipping-matrix/

对于每一行，要知道第一列是1比剩下的加起来起到的效果都大
即2^n > 2^(n-1) + 2^(n-2) + ... + 1
所以从贪心的角度，要先把第一列全都变成1
之后算每一列的0和1的总数，如果0小于1的个数，就反过来
最后算总数即可

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) cnt++;
            }
            if (cnt > m - cnt) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int score = grid[i][j] << (n - j - 1);
                res += score;
            }
        }
        return res;
    }
}