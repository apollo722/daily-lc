class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            int heightL = height[l], heightR = height[r];
            res = Math.max(res, (r - l) * Math.min(heightL, heightR));
            if (heightL < heightR) l++;
            else r--;
        } 
        return res;
    }
}