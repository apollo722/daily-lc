/*
https://leetcode.com/problems/minimum-time-visiting-all-points/

按顺序扫描每对点，之间需要的最短时间即为二者横纵坐标插值绝对值的较大者

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length, res = 0;
        for (int i = 1; i < n; i++) {
            int[] prev = points[i - 1], cur = points[i];
            res += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return res;
    }
}