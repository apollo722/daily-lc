/*
https://leetcode.com/problems/jump-game-ii/

贪心思想
记录每次能跳到的最远距离
每次下标到最远距离的时候，结果+1（相当于用1跳到了最远的下标）
如果此时下标已经cover n-1那么就返回结果

举例：[2,3,1,1,4]
初始last = 0，max = 0
i = last = 0的时候，结果++，此时跳到max = 2
i = last = 2的时候，结果++，此时跳到max = 4，满足条件，返回


Time: O(n)
Space: O(1)
*/

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length, last = 0, max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == last) {
                res++;
                last = max;
                if (last >= n - 1) return res;
            }
        }
        return res;
    }
}