/*
https://leetcode.com/problems/remove-covered-intervals/

类似1996 https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
升序左边界，降序右边界
从左往右扫，track max end so far

本题不能用类似1996题桶排序的思维是因为1996题两个attribute都是单向条件（同小于），而本题是一大一小

Time: O(nlogn)
Space: O(1)，不考虑排序需要的空间O(logn)
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int res = 0, maxEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[1] <= maxEnd) res++;
            maxEnd = Math.max(maxEnd, interval[1]);
        }
        return intervals.length - res;
    }
}