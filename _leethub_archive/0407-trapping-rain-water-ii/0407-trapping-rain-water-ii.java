class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        int[] dir = {-1, 0, 1, 0, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int res = 0, curLevel = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    pq.add(new int[]{i, j, heightMap[i][j]});
                }
            }
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


/*
感觉很多问题无从下手都是思路上的问题。
哪里的水才能被困住呢？四周都更高，被困住的水就是四周最矮的高度与当前高度的差。
如果四周的格子是水，也可以当作边界来看，因为水能被困住证明再远一点有边界。
最后走到最远就是四周那一圈。从最外面来看一点点往里找边界。
所以如果从边界往里，而且按照从低到高的顺序扫描，就能把困住的水找到。
为什么呢？从边界开始，相当于外面有一片海洋，从外向内流。
按照从低到高扫描，每次再扫描其四周，如果四周更矮就一定能困住水。
所以用一个优先队列先把边界装进去，每次扫描目前最低的四周，如果遇到更低的就把它和当前元素的差放到结果，相当于困住了水。
*/