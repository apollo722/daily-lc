/*
https://leetcode.com/problems/majority-element/

Boyer-Moore投票算法
相同数字cnt++，不同数字cnt--，cnt为零重置数字
最后剩的数字即为答案（假设答案一定存在）

Time: O(n)
Space: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt++;
            } else if (res == nums[i]) cnt++;
            else cnt--;
        }
        return res;
    }
}