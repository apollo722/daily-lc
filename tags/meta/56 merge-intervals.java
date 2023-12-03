/*
https://leetcode.com/problems/merge-intervals/

按照起点排序，每次遇到一个新的区间，看能不能和前一个区间合并
如果区间起点大于之前的终点，则不能，直接加入结果
否则，之前的区间的终点应被置成二者终点的较大者

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> l = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] i : intervals) {
            if (l.isEmpty() || l.get(l.size() - 1)[1] < i[0]) l.add(i);
            else {
                int end = Math.max(l.get(l.size() - 1)[1], i[1]);
                l.get(l.size() - 1)[1] = end;
            }
        }
        int[][] res = new int[l.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}