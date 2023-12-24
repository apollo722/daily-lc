/*
https://leetcode.com/problems/trapping-rain-water/

two pointer模板
中间能装多少水取决于两侧边界的较小值
任何一个位置能存多少水取决于它两侧见过的最大边界中的较小高度，因为是较小者，所以相当于只track了它一侧的side，另一侧的side更大反正也不会贡献什么
再用如下例子解释一下：
对于位置1，直观上只能存储1格，但其实能存储2格，因为它右侧最高的边界在位置5，水会跨过2被5留住
所以某一格能存多少水，先找到它两侧能看到的最大边界，再计算两侧边界的较小值与当前base的差
                __  
 __            |  |
|  |   __      |  | 
|__|__|__|__ __|__| 
 0  1  2  3  4  5

用两个ptr分别记录两侧目前最大的高度，并向中间收缩，每收缩到一个位置，先更新两侧边界的最大值，并找到其中的较小者
这一步相当于找到还未扫过的中间位置的两侧边界的最大值
对于当前位置，能存储的水即当前两侧边较小者与当前位置的高度差
每次移动较小高度那侧的ptr即可，这是因为移动较小者才有可能找到更大的边，移动更大的一侧反正也不会贡献什么

Time: O(n)
Space: O(1)
*/

class Solution {
    public int trap(int[] height) {
        int res = 0, l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        while (l < r) {
            int leftSide = height[l], rightSide = height[r];
            lMax = Math.max(lMax, leftSide);
            rMax = Math.max(rMax, rightSide);
            int minSide = Math.min(lMax, rMax);
            if (leftSide < rightSide) {
                res += minSide - leftSide;
                l++;
            } else {
                res += minSide - rightSide;
                r--;
            }
        }
        return res;
    }
}