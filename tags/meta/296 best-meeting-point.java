/*
https://leetcode.com/problems/best-meeting-point/

暴力解法即算出每个点对于其他位置的曼哈顿距离，找到最小的即可
如果考虑一维问题，即 1 0 1 0 0 1，最短距离是多少？
最直观的想法是大家都到相对最中间的那个人处meet，即所有1的median位置
把行和列看作两个一维问题求解，和即为答案
直观求解即统计每行/列1的位置，并把它们按照位置排序，找到median，再计算每个位置与median的距离和

复杂度更优化的解法即分别为行和列扫描两边输入，使得行和列的1位置返回序列自然排好序
之后再计算头尾差的和即可

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = getRow(grid), col = getCol(grid);
        return calc(row) + calc(col);
    }

    private List<Integer> getRow(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) res.add(i);
            }
        }
        return res;
    }

    private List<Integer> getCol(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) res.add(i);
            }
        }
        return res;
    }

    private int calc(List<Integer> list) {
        int res = 0, l = 0, r = list.size() - 1;
        while (l < r) {
            res += list.get(r--) - list.get(l++);
        }
        return res;
    }
}