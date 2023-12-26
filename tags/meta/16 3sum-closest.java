/*
https://leetcode.com/problems/3sum-closest/

two ptr模板，排序后固定一个idx后用two ptr查找最小差的和即可

Time: O(n^2)
Space: O(logn)，排序所需空间
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];
                int curDiff = curSum - target;
                if (curDiff == 0) return target;
                if (Math.abs(curDiff) < Math.abs(minDiff)) minDiff = curDiff;
                if (curSum > target) r--;
                else l++;
            }
        }
        return target + minDiff;
    }
}