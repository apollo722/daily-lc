/*
https://leetcode.com/problems/rearrange-array-elements-by-sign/

用两个ptr来根据情况逐个放入结果
没有想到/找到正确的in place的答案

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, pos = 0, neg = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[pos] = nums[i];
                pos += 2;
            } else {
                res[neg] = nums[i];
                neg += 2;
            }
        }
        return res;
    }
}