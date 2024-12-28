/*
https://leetcode.com/problems/build-array-from-permutation/

难点是如何达到O(1)空间
由于题目给定nums[i]小于等于1000，所以就会有一些操作空间：
1. 位运算：https://leetcode.com/problems/build-array-from-permutation/solutions/1315480/java-o-1-space-o-n-time/
2. 一种转换算法：https://leetcode.com/problems/build-array-from-permutation/solutions/1419134/interview-approach-o-1-space/

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}