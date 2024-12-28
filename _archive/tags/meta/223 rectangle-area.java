/*
https://leetcode.com/problems/rectangle-area/

分别找到上下左右四条边，如果任何一对边有overlap，只返回面积和
否则减去overlap的部分

Time: O(1)
Space: O(1)
*/

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        int left = Math.max(ax1, bx1), right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2), bottom = Math.max(ay1, by1);
        int res = area1 + area2;
        if (top <= bottom || left >= right) return res;
        return res - (right - left) * (top - bottom);
    }
}