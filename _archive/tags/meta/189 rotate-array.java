/*
https://leetcode.com/problems/rotate-array/

分段反转，再整体反转
先把前n-k个反转了，再把后k个反转了
最后整体反转，就是答案！
注意k可能太大，要对n取余

Time: O(n)
Space: O(1)
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}