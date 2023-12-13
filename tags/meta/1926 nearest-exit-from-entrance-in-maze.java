/*
https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/

BFS模板

Time: O(mn)
Space: O(max(m, n))，worst情况q里最多装O(m + n)个元素
*/

class Solution {
    int m, n;
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        m = maze.length;
        n = maze[0].length;
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int i = dir[d] + cur[0], j = dir[d + 1] + cur[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != '+') {
                        if (isBoarder(i, j)) return res;
                        q.add(new int[]{i, j});
                        maze[i][j] = '+';
                    }
                }
            }
        }
        return -1;
    }

    private boolean isBoarder(int i, int j) {
        return i == 0 || i == m - 1 || j == 0 || j == n - 1;
    }
}