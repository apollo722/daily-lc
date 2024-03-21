/*
https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

按照题意顺序查找即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int curRes = -1, maxDis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int curX = points[i][0], curY = points[i][1];
            if (curX != x && curY != y) continue;
            int curDis = Math.abs(x - curX) + Math.abs(y - curY);
            if (curDis < maxDis) {
                curRes = i;
                maxDis = curDis;
            }
        }
        return curRes;
    }
}