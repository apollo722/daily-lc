class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        int[] dir = {-1, 0, 1, 0, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int res = 0, curLevel = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0, heightMap[i][0]});
            pq.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            pq.add(new int[]{0, i, heightMap[0][i]});
            pq.add(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], h = cur[2];

            for (int d = 0; d < 4; d++) {
                int i = x + dir[d], j = dir[d + 1] + y;
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    visited[i][j] = true;
                    int nextHeight = heightMap[i][j];
                    if (h > heightMap[i][j]) res += h - nextHeight;
                    pq.add(new int[]{i, j, Math.max(nextHeight, h)});
                }
            }
        }
        return res;
    }
}
