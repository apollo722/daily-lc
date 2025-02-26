class Solution {
    public int trap(int[] height) {
        int res = 0, l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        while (l < r) {
            int curLeft = height[l], curRight = height[r];
            lMax = Math.max(lMax, curLeft);
            rMax = Math.max(rMax, curRight);
            int minSide = Math.min(lMax, rMax);
            if (lMax < rMax) {
                res += minSide - curLeft;
                l++;
            } else {
                res += minSide - curRight;
                r--;
            }
        }
        return res;
    }
}


/*
two pointer思路。
某个格子能被困住多少的水取决于它两侧最高边界的较小值。
这里两侧的边界指的是目前从两侧向中间收缩时遇到的最大边界。为什么是遇到的最大边界呢？
用下面的例子解释一下：

                __  
 __            |  |
|  |   __      |  | 
|__|__|__|__ __|__| 
 0  1  2  3  4  5

对于位置1，直观上只能存储1格，但其实能存储2格，因为它右侧最高的边界在位置5，水会跨过2被5留住。
所以某一格能存多少水，先找到它两侧能看到的最大边界，再计算两侧边界的较小值与当前base的差。
如果0的左侧和5的右侧还有更矮的，并不会影响当前格子1能存的水，因为离1最近最高的遇到的是0和5。

所以对于任意一格，它能存的水，是它自己的高度与两侧遇到最高值中较小者的差。
如何移动边界呢？肯定想找更高的边界，因为可以困住更多水。所以看目前观测到的最高边界，哪边小就移动哪边的pointer，因为这样可以有更多机会遇到更高的边界。
*/