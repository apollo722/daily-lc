/*
https://leetcode.com/problems/minimum-average-difference/

先求出总和，每次扫描一个元素，左侧和即为当前和+=当前元素，右侧和即为总数-=当前元素

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long leftSum = 0, rightSum = 0, min = Integer.MAX_VALUE;
        int res = -1, n = nums.length;
        for (int num : nums) rightSum += num;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            long right = rightSum == 0 ? 0 : rightSum / (n - i - 1), left = leftSum / (i + 1);
            long diff = Math.abs(left - right);
            if (diff == 0) return i;
            if (min > diff) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}