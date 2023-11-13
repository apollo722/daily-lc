/*
https://leetcode.com/problems/longest-consecutive-sequence/

把所有数字放到set
每次扫描一个数字
如果set里面包括这个数字，那就边搜寻+1/-1的数字边remove from set
并统计包括当前数字最大范围
如果set已经空了就可以结束查找

Time: O(n)，因为每次查询都从set中remove，所以每个数字最多被查询一次
Space: O(n)
*/


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        int res = 0;
        for (int num : nums) {
            if (!s.contains(num)) continue;
            int cnt = 1;
            s.remove(num);
            int hi = num + 1, lo = num - 1;
            while (s.contains(hi)) {
                cnt++;
                s.remove(hi);
                hi++;
            }
            while (s.contains(lo)) {
                cnt++;
                s.remove(lo);
                lo--;
            }
            res = Math.max(cnt, res);
            if (s.size() == 0) break;
        }
        return res;
    }
}