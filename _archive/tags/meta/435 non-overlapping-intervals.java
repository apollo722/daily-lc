/*
https://leetcode.com/problems/non-overlapping-intervals/

按照终点排序，因为终点越靠前，余下的选择就越多，也就会使得需要remove的区间越小

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0, prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            if (curStart < prevEnd) res++;
            else prevEnd = intervals[i][1];
        }
        return res;
    }
}