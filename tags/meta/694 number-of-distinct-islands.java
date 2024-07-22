/*
https://leetcode.com/problems/number-of-distinct-islands/

dfs找到所有的岛，问题是如何确定岛的形状
可以把所有的坐标按照最左上的顶点对其，之后放到set中即可

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int curRow;
    int curCol;
    boolean[][] visited;
    int[][] grid;
    Set<Pair<Integer, Integer>> curIsland;
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.curIsland = new HashSet<>();
                this.curRow = i;
                this.curCol = j;
                dfs(i, j);
                if (!curIsland.isEmpty()) islands.add(curIsland);
            }
        }
        return islands.size();
    }

    private void dfs(int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        curIsland.add(new Pair<>(row - this.curRow, col - this.curCol));
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}