/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

每一个时刻直到subarray中最大值和最小值才能知道当前的数组是否符合要求
需要两个单调栈，分别来追踪最大和最小值
每一时刻如果两个栈首差符合要求，那么右移窗口
如果不符合，需要右移窗口左边界
因为单调栈的元素都是顺序加入的，所以只有当栈首是当前左窗口的时候才需要移除，意为当前栈首已经不在考虑范围了

Time: O(n)
Space: O(n)
*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minSt = new ArrayDeque<>(), maxSt = new ArrayDeque<>();
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            while (!minSt.isEmpty() && nums[minSt.peekLast()] >= nums[r]) minSt.pollLast();
            while (!maxSt.isEmpty() && nums[maxSt.peekLast()] <= nums[r]) maxSt.pollLast();
            minSt.addLast(r);
            maxSt.addLast(r);
            if (nums[maxSt.peekFirst()] - nums[minSt.peekFirst()] > limit) {
                if (maxSt.peekFirst() == l) maxSt.pollFirst();
                if (minSt.peekFirst() == l) minSt.pollFirst();
                l++;
            }
            r++;
        }
        return r - l;
    }
}