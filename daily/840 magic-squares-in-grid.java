/*
https://leetcode.com/problems/magic-squares-in-grid/

代码题，注意到中心元素只能是5

Time: O(nm)
Space: O(1)
*/

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        if (m * n < 9) return 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 5) {
                    if (valid(grid, i, j)) res++;
                }
            }
        }
        return res;
    }

    private boolean valid(int[][] grid, int r, int c) {
        Set<Integer> s = new HashSet<>();
        for (int i = r - 1; i <= r + 1; i++) {
            int rowSum = 0;
            for (int j = c - 1; j <= c + 1; j++) {
                int cur = grid[i][j];
                if (cur < 1 || cur > 9) return false;
                if (s.contains(cur)) return false;
                s.add(cur);
                rowSum += cur;
            }
            if (rowSum != 15) return false;
        }
        if (grid[r - 1][c - 1] + grid[r][c - 1] + grid[r + 1][c - 1] != 15) return false;
        if (grid[r - 1][c] + grid[r][c] + grid[r + 1][c] != 15) return false;
        if (grid[r - 1][c + 1] + grid[r][c + 1] + grid[r + 1][c + 1] != 15) return false;
        if (grid[r - 1][c - 1] + grid[r + 1][c + 1] != 10) return false;
        if (grid[r + 1][c - 1] + grid[r - 1][c + 1] != 10) return false;
        return true;
    }
}