/*
https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

对比每一对相邻元素，并追踪现在是上升还是下降段
如果是同样的元素，则什么也没发生
否则如果在上升段，那么之前见过下降段，则结果++，反之亦然

Time: O(n)
Space: O(1)
*/

class Solution {
    public int countHillValley(int[] nums) {
        Boolean flag = null;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            else if (nums[i] > nums[i - 1]) {
                if (flag != null && !flag) res++;
                flag = true;
            } else {
                if (flag != null && flag) res++;
                flag = false;
            }
        }
        return res;
    }
}