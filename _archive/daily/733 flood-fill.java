/*
https://leetcode.com/problems/flood-fill/

DFS模板，如果和起点颜色相同且和目标颜色不同，就DFS继续涂

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;

    }

    private void dfs(int[][] image, int row, int col, int tar, int prev) {
        int m = image.length, n = image[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != prev || image[row][col] == tar) return;
        image[row][col] = tar;
        dfs(image, row + 1, col, tar, prev);
        dfs(image, row - 1, col, tar, prev);
        dfs(image, row, col + 1, tar, prev);
        dfs(image, row, col - 1, tar, prev);
    }
}