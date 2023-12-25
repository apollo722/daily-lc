/*
https://leetcode.com/problems/subarray-product-less-than-k/

sliding window变种
唯一注意的是subarray个数的计算，用nums = [10,5,2,6], k = 100作为例子
[10]，res += 1 -> res = 1，[10]
[10,5]，res += 2 -> res = 3，相当于多了[5]，[10,5]
[5,2]，res += 2 -> res = 5，相当于多了[2]，[5,2]
[5,2,6]，res += 3 -> res = 8，相当于多了[6]，[2,6]，[5,2,6]
即，每到一个位置，就会多r-l+1个以这个位置为终点的subarray

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length, l = 0, r = 0, res = 0, prod = 1;
        while (r < n) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l++];
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}