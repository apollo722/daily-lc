class Solution {
    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> q = new ArrayDeque<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        int step = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.pollFirst();
                for (int d = 0; d < 4; d++) {
                    int x = dir[d] + cur[0], y = dir[d + 1] + cur[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] != 0 && rooms[x][y] != -1 && rooms[x][y] > step) {
                        rooms[x][y] = step;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return ;
    }
}