/*
https://leetcode.com/problems/maximum-product-subarray/

同时track当前的最大和最小值即可
最大值可能是当前元素值乘当前最小值，也可能是乘最大值
当前最小值同理
而每个位置的最大值即为累计最大值和当前最大值的大者

也可以正反扫描两边数组，找到最大值，因为从两边分别扫描一遍可以抵消负数个数的影响
public int maxProduct(int[] nums) {
    int prod = 1, res = Integer.MIN_VALUE;
    for (int num : nums) {
        prod *= num;
        res = Math.max(res, prod);
        if (num == 0) prod = 1;
    }
    prod = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        prod *= nums[i];
        res = Math.max(res, prod);
        if (nums[i] == 0) prod = 1;
    }
    return res;
}

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int curMin = nums[0], curMax = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int tmpCurMax = Math.max(cur, Math.max(cur * curMin, cur * curMax));
            curMin = Math.min(cur, Math.min(cur * curMin, cur * curMax));
            curMax = tmpCurMax;
            res = Math.max(res, curMax);
        }
        return res;
    }
}