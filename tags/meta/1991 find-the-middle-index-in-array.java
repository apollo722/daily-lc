/*
https://leetcode.com/problems/find-the-middle-index-in-array/

求出总和之后每扫描一个数字就从总和中减去
这样左边就是当前和，右边就是总和减当前数字

Time: O(n)
Space: O(1)
*/

class Solution {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0, sum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (leftSum == sum - curNum) return i;
            leftSum += curNum;
            sum -= curNum;
        }
        return -1;
    }
}