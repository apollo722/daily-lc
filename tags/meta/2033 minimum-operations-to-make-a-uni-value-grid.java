/*
https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

最小的操作次数一定是所有元素收敛于整个元素集的中位数处（或者说中间的元素之一，不是真的中位数）
所以将整体元素排序，之后计算每个元素移动到中位数需要多少步
如果任何元素无法归到中位数，即无法被x整除，直接返回-1

Time: O(mnlog(mn))
Space: O(mn)
*/

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, len = m * n, idx = 0;
        int[] arr = new int[len];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int res = 0, mid = arr[len / 2];
        for (int num : arr) {
            if (Math.abs(num - mid) % x != 0) return -1;
            res += Math.abs(num - mid) / x;
        }
        return res;
    }
}