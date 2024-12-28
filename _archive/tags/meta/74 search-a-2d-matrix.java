/*
https://leetcode.com/problems/search-a-2d-matrix/

先二分查找target在哪一行
再二分查找行内元素

Time: O(log(mn) = logm + logn)
Space: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1, rIdx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] > target) r = mid - 1;
            else {
                rIdx = mid;
                l = mid + 1;
            }
        }
        if (rIdx == -1) return false;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[rIdx][mid] == target) return true;
            else if (matrix[rIdx][mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}