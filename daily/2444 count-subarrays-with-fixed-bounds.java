/*
https://leetcode.com/problems/count-subarrays-with-fixed-bounds/

sliding window变种
一个比较通用的想法来求满足条件的subarr个数是固定终点，之后找以此终点为结尾的subarr有多少个符合条件
此题满足条件的subarr有三个条件：
1. 里面不能含有超过minK与maxK范围的元素
2. 里面至少有一个minK
3. 里面至少有一个maxK
如果能知道最后一个超过范围的元素的位置，以及最后一个min与max的位置，那么这之间的所有位置作为起点到固定的终点都是合法的
例子: [x, x, L(最后一个范围外的元素), x, minK, maxK, x, minK, maxK, x, R, x]
       0, 1, 2,                     3, 4,    5,    6, 7,    8,    9, 10,11
固定终点到R的位置，最后出现的minK与maxK的位置的较小者是7，那么意味着7到R的位置10这之间至少是存在最大与最小值的
那么还要看这中间是否存在不在范围内的数
上一个不在范围内的数是在2的位置，也就是说从3开始到R中间所有的数都是符合范围的
只要找到一个范围能包含所有上述三个条件的范围就行，也就是从3开始，到7结束中的每个位置作为subarr起点，到R终点，都符合要求
即早于等于7开始，就一定包含minK和maxK，晚于2开始的元素都是范围内的，所以7-2=5，有5个起点可以与R组成subarr

Time: O(n)
Space: O(1)
*/

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int l = -1, minPos = -1, maxPos = -1, n = nums.length, r = 0;
        while (r < n) {
            int cur = nums[r];
            if (cur < minK || cur > maxK) l = r;
            if (cur == minK) minPos = r;
            if (cur == maxK) maxPos = r;
            res += Math.max(0, Math.min(minPos, maxPos) - l);
            r++;
        }
        return res;
    }
}