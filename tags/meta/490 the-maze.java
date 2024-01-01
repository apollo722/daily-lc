/*
https://leetcode.com/problems/the-maze/

标准DFS模板
要注意如果利用原输入来作为visited数组，那么每次访问要置为另一个数字而不能是墙代表的1
因为move球的时候不能穿墙但是可以穿过已经visited过的位置，即move操作需要用1来判断是否停下

Time: O(mn(m + n))，dfs需要mn的复杂的，移动球需要m+n
Space: O(mn)
*/

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] cur, int[] dest) {
        int m = maze.length, n = maze[0].length;
        if (cur[0] == dest[0] && cur[1] == dest[1]) return true;
        maze[cur[0]][cur[1]] = 2;
        for (int d = 0; d < 4; d++) {
            int[] next = getNext(cur, maze, m, n, d);
            if (maze[next[0]][next[1]] == 2) continue;
            if (dfs(maze, next, dest)) return true;
        }
        return false;
    }

    int[] dir = {-1, 0, 1, 0, -1};
    private int[] getNext(int[] cur, int[][] maze, int m, int n, int d) {
        int x = cur[0] + dir[d], y = cur[1] + dir[d + 1];
        while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
            x += dir[d];
            y += dir[d + 1];
        }
        return new int[]{x - dir[d], y - dir[d + 1]};
    }
}