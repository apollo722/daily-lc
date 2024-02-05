/*
https://leetcode.com/problems/number-of-corner-rectangles/

因为要找到四个不同的等于1的角，所以只关注1且为角的格子
对于每一行i，分别搜索列j和k，当j和k位置都是1的时候，就在行内找到了一个高度为1的数对
如果在之前的某一行的j和k位置也能形成数对，那么就会组成一个题目要求的矩形
所以用dp[n][n]来存储所有可能的列位置，记录每一个找到的数对个数
之后每找到一对，直接加入结果，并更新数对的个数即可

Time: O(mn^2)
Space: O(n^2)
*/

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = j + 1; k < n; k++) {
                        if (grid[i][k] == 1) {
                            res += dp[j][k];
                            dp[j][k]++;
                        }
                    }
                }
            }
        }
        return res;
    }
}