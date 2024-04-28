/*
https://leetcode.com/problems/right-triangles/

对于一个1元素，把它作为三角形的角点，它能组成的三角个数
即为它所在行的1元素的个数-1，乘以他所在列的1元素个数-1
所以统计每一行与列的1的个数即可

Time: O(mn)
Space: O(n + m)
*/

class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] cntRow = new int[m], cntCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cntRow[i]++;
                    cntCol[j]++;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += (cntRow[i] - 1) * (cntCol[j] - 1);
                }
            }
        }
        return res;
    }
}