/*
https://leetcode.com/problems/shortest-distance-from-all-buildings/

BFS模板
对于每个1，运行一次bfs，并记录下跟所有可以走到的格子的距离
利用一个变量记录每次走到过哪些格子，比如第一个1要找都是0的地方，所有0在第一个1的遍历中都置成-1
第二个1就可以找都是-1的地方，之后置成-2
每一轮bfs都可以返回能走到的地方的最小累计距离
如果没有可以走到的地方了，返回MAX，这样即可提前知道没有符合结果的格子，返回-1

Time: O(m^2 n^2)，如果一半是0，一半是1，那么每个1都要走mn/2次，即m^2 n^2
Space: O(mn)
*/

class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        int res = Integer.MAX_VALUE;
        int check = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int getDist = Math.min(Integer.MAX_VALUE, bfs(grid, dist, i, j, check--));
                    if (getDist == Integer.MAX_VALUE) return -1;
                    res = getDist;
                }
            }
        }
        return res;
    }
    int[] dir = {-1, 0, 1, 0, -1};
    private int bfs(int[][] grid, int[][] dist, int r, int c, int check) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int res = Integer.MAX_VALUE, curDist = 0;
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            curDist++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int i = cur[0] + dir[d], j = cur[1] + dir[d + 1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == check) {
                        dist[i][j] += curDist;
                        res = Math.min(res, dist[i][j]);
                        grid[i][j] = check - 1;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return res;
    }
}