/*
https://leetcode.com/problems/walls-and-gates/

从所有gate开始BFS
如果距离更小则新更

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int x = cur[0] + dir[d], y = cur[1] + dir[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] != -1 && rooms[x][y] != 0 && rooms[x][y] > dist) {
                        rooms[x][y] = dist;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}