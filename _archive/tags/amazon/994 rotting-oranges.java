/*
https://leetcode.com/problems/rotting-oranges/

BFS模板
需要注意的是只有腐蚀到橘子才会增加时间，所以需要用flag来记录某一层是否真的腐蚀到了橘子
最后统计是否所有橘子都被腐蚀

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }
        int res = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            flag = false;
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nextX = cur[0] + dir[d], nextY = cur[1] + dir[d + 1];
                    if (nextX < m && nextX >= 0 && nextY < n && nextY >= 0 && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = -1;
                        q.add(new int[]{nextX, nextY});
                        flag = true;
                    }
                }
            }
            if (flag) res++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}