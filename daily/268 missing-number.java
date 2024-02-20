/*
https://leetcode.com/problems/missing-number/

可以用数学的算法，求出[0,n]应该有的和，和数组的sum，差值即为所求
也可以位运算，异或相同数字的结果为零，那么下标和元素全都异或起来最后的结果即为缺少的元素

Time: O(n)
Space: O(1)
*/

class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            res ^= i ^ nums[i - 1];
        }
        return res;
    }
}