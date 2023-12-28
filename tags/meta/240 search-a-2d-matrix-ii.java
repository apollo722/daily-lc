/*
https://leetcode.com/problems/search-a-2d-matrix-ii/

因为每行每列都是排序好的，所以可以从右上角开始扫描
如果元素等于target则返回true
如果元素小于target，那么要向更大的方向找去，即沿着列方向向下
反之，则要找更小的方向，即沿着行向左
所以要么向下要么向左，一开始就应该从右上角开始找，这样可以找全所有的元素

Time: O(m + n)
Space: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}