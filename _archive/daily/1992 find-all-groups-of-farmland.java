/*
https://leetcode.com/problems/find-all-groups-of-farmland/

DFS模板
每次遇到的1元素都一定是最左上的的那个，因为如果能连上，其它1已经在之前的dfs中处理完了
只需要每次记录一下dfs扫过元素的最右下角的值即可
注意每次dfs要重置最右下角的值以便能取到每个岛的最大右下角

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int br = 0, bc = 0;
    int[] dir = {-1, 0, 1, 0, -1};
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    br = 0;
                    bc = 0;
                    dfs(land, i, j);
                    resList.add(new int[]{i, j, br, bc});
                }
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }

    private void dfs(int[][] land, int row, int col) {
        land[row][col] = 0;
        br = Math.max(br, row);
        bc = Math.max(bc, col);
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + row, j = dir[d + 1] + col;
            if (i >= 0 && i < land.length && j >= 0 && j < land[0].length && land[i][j] == 1) {
                dfs(land, i, j);
            }
        }
    }
}