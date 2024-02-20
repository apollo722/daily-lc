/*
https://leetcode.com/problems/island-perimeter/

扫描每个岛，结果会+4条边
如果上方或者左侧也是岛，证明有公共边变成了陆地，边属于两个岛块，所以res-=2

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) res -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) res -= 2;
                }
            }
        }
        return res;
    }
}