/*
https://leetcode.com/problems/find-a-peak-element-ii/

二分查找，先选一个中间的col，之后找到col中的最大值的那一行，之后比较此行的元素是否比col左右都大，如果是，就找到了结果
题目保证了没有任何相邻元素是相等的，所以一列中的最大值一定是peak的备选，任何比其小的一定不可能是答案
如果这个col中的最大值不是答案，那么就向着比它更大的那个col找去即可

Time: O(mlogn)
Space: O(1)
*/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int col = l + (r - l) / 2;
            int row = findMax(mat, col);
            int left = col - 1 >= 0 ? mat[row][col - 1] : -1;
            int right = col + 1 < n ? mat[row][col + 1] : -1;
            if (mat[row][col] > left && mat[row][col] > right) return new int[]{row, col};
            else if (mat[row][col] <= left) r = col - 1;
            else l = col + 1;
        }
        return new int[]{-1, -1};
    }

    private int findMax(int[][] mat, int col) {
        int m = mat.length, res = -1, max = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                res = i;
            }
        }
        return res;
    }
}