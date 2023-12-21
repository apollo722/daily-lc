/*
https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

按x坐标排序并计算差值即可

Time: O(nlogn)
Space: O(logn)，排序所需要的空间复杂度
*/

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int n = points.length, res = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] == points[i - 1][0]) continue;
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }
}