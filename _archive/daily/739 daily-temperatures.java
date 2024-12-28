/*
https://leetcode.com/problems/daily-temperatures/

从最右侧开始扫描，记录最大值，如果当前温度大于当前最大值，更新最大值，并且啥也不需要做
如果当前温度小于最大值，证明右侧有比它温度更高的天
用一个循环，目的是找到第一个温度比它高的那天，从它的后一天开始，i+cnt，cnt=1
如果它的后一天已经比它温度高了，那么相当于找到了，直接置入cnt=1到结果中
如果没有，因为它的后一天之前扫描过，比它后一天温度高的天数一定已经存在结果中了
且比它后一天温度高的那天之前都不会比它温度高，所以下一个要找的位置直接取res[i+cnt]，意为看一下i+res[cnt+i]这天是不是比i处温度高
如此反复，直到找到温度更高的那天，计入结果即可

Time: O(n)
Space: O(1)
*/


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int maxTemp = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = temperatures[i];
            if (cur >= maxTemp) {
                maxTemp = cur;
                continue;
            }
            int cnt = 1;
            while (temperatures[i + cnt] <= cur) {
                cnt += res[cnt + i];
            }
            res[i] = cnt;
        }
        return res;
    }
}