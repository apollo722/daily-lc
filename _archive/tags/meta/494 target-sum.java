/*
https://leetcode.com/problems/target-sum/

最朴素的想法就是每一个位置前面分别放上加号或者减号
即枚举所有可能的结果，共2^n个可能，每当curSum==target时即结果++

但这之中很多计算是重复的，比如+1-1+1-1与-1+1-1+1
所以可以可以利用memo来存储已计算的结果，即[idx,curSum]，每一位置能组成curSum的个数
curSum的范围为[-total,total]，所有数值+total即可使之以0为base
跟朴素想法一样检查每个位置，分别放上加号或减号，并存储结果到memo中，结果即为add和sub之和

转换成dp可以优化成O(t)空间：https://leetcode.com/problems/target-sum/editorial/

Time: O(tn)，t为数组和
Space: O(tn)
*/

class Solution {
    Integer[][] memo;
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) total += num;
        memo = new Integer[nums.length + 1][2 * total + 1];
        return calc(nums, 0, 0, target);
    }

    private int calc(int[] nums, int idx, int curSum, int target) {
        if (idx == nums.length) {
            if (curSum == target) return 1;
            else return 0;
        }
        if (memo[idx][curSum + total] != null) return memo[idx][curSum + total];
        int add = calc(nums, idx + 1, curSum + nums[idx], target);
        int sub = calc(nums, idx + 1, curSum - nums[idx], target);
        memo[idx][total + curSum] = add + sub;
        return add + sub;
    }
}