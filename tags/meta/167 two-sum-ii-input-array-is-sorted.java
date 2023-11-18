/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

因为已经排好序，直接从数组两边向内开始扫描即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum < target) l++;
            else r--;
        }
        return null;
    }
}