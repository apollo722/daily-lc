/*
https://leetcode.com/problems/pacific-atlantic-water-flow/

DFS变种
用两个boolean矩阵来标记哪些格子可以被大洋覆盖
从边界开始反向DFS
最后总结能同时被两个大洋覆盖的格子

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int[] dir = {1, 0, -1, 0, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] visitP = new boolean[m][n], visitA = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, visitP);
            dfs(heights, m - 1, i, visitA);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, visitP);
            dfs(heights, i, n - 1, visitA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitP[i][j] && visitA[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(new Integer[]{i, j})));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int d = 0; d < 4; d++) {
            int i = row + dir[d], j = col + dir[d + 1];
            if (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length && !visited[i][j] && heights[i][j] >= heights[row][col]) {
                dfs(heights, i, j, visited);
            }
        }
    }
}