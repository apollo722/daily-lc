/*
https://leetcode.com/problems/number-of-distinct-islands-ii/

找岛屿不难，难点是如何建模来判断两座岛屿是否全等
其中一种办法是把岛屿里的每一对点的距离计算出来，连同距离出现的频率，放到map中
拥有相同map的岛即为全等岛

Time: O(m^2 n^2)
Space: O(mn)
*/

class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    public int numDistinctIslands2(int[][] grid) {
        Set<Map<Integer, Integer>> res = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> list = new ArrayList<>();
                    dfs(grid, i, j, list);
                    res.add(getIsland(list));
                }
            }
        }
        return res.size();
    }

    private void dfs(int[][] grid, int r, int c, List<int[]> list) {
        list.add(new int[]{r, c});
        grid[r][c] = 0;
        int m = grid.length, n = grid[0].length;
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + r, j = dir[d + 1] + c;
            if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1) {
                dfs(grid, i, j, list);
            }
        }
    }

    private Map<Integer, Integer> getIsland(List<int[]> list) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int dist = getDist(list.get(i), list.get(j));
                res.put(dist, res.getOrDefault(dist, 0) + 1);
            }
        }
        return res;
    }

    private int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}