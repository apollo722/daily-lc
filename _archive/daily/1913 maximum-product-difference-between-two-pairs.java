/*
https://leetcode.com/problems/maximum-product-difference-between-two-pairs/

找到最大的和最小的两对数即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxProductDifference(int[] nums) {
        int l1 = Integer.MIN_VALUE, l2 = l1, s1 = Integer.MAX_VALUE, s2 = s1;
        for (int num : nums) {
            if (num > l1) {
                l2 = l1;
                l1 = num;
            } else if (num > l2) l2 = num;
            if (num < s1) {
                s2 = s1;
                s1 = num;
            } else if (num < s2) s2 = num;
        }
        return (l1 * l2) - (s1 * s2);
    }
}