/*
https://leetcode.com/problems/jump-game/

Greedy反向跳
初始last位于n - 1
每次看i + nums[i]是否能cover到last
如果可以即说明当前i可以跳到last
只要看最后last是否等于0即可


Time: O(n)
Space: O(1)
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}