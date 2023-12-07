/*
https://leetcode.com/problems/insert-interval/

分段添加
先把newInt前面不重合的加到结果
之后看newInt能cover多少
最后把后面不重合的加到结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        int idx = 0, n = intervals.length;
        while (idx < n && intervals[idx][1] < newInterval[0]) {
            l.add(intervals[idx++]);
        }
        if (idx == n) {
            l.add(newInterval);
            return process(l);
        }
        int start = Math.min(intervals[idx][0], newInterval[0]), end = newInterval[1];
        while (idx < n && intervals[idx][0] <= newInterval[1]) {
            end = Math.max(intervals[idx++][1], end);
        }
        l.add(new int[]{start, end});
        while (idx < n) l.add(intervals[idx++]);
        return process(l);
    }

    private int[][] process(List<int[]> l) {
        int[][] res = new int[l.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}