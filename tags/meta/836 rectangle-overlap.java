/*
https://leetcode.com/problems/rectangle-overlap/

代码题，看上边界下边界和左边界右边界是否有overlap

Time: O(1)
Space: O(1)
*/

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && 
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}