/*
https://leetcode.com/problems/container-with-most-water/

标准two ptr
从两边开始扫，每次移动较小的边即可
因为移动更小的才有可能找到更大的困水体积

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            int left = height[l], right = height[r];
            res = Math.max(res, Math.min(left, right) * (r - l));
            if (left < right) l++;
            else r--;
        }
        return res;
    }
}