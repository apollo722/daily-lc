/*
https://leetcode.com/problems/remove-interval/

扫描每一个interval，如果和目标不相交，直接放入结果
如果相交，就需要把前后不相交的部分切割出来放入结果
注意有可能interval比目标还要长，即可以同时有前后两段满足条件
即每一个interval都要进行前后的切割

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int start = toBeRemoved[0], end = toBeRemoved[1];
        for (int[] interval : intervals) {
            int s = interval[0], e = interval[1];
            if (e <= start || s >= end) res.add(Arrays.asList(s, e));
            else {
                if (s < start) res.add(Arrays.asList(s, start));
                if (e > end) res.add(Arrays.asList(end, e));
            }
        }
        return res;
    }
}