/*
https://leetcode.com/problems/minimum-increment-to-make-array-unique/

排序后贪心，每次都是前一个+1即可

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int minSlot = nums[0] + 1, res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minSlot) {
                res += minSlot - nums[i];
                nums[i] = minSlot;
            }
            minSlot = nums[i] + 1;
        }
        return res;
    }
}