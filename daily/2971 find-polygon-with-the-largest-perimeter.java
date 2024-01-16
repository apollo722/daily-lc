/*
https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/

先求出数组和，之后排序
从后向前依次检查最大的边是否满足条件即可

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) sum += num;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < 2) return -1;
            int num = nums[i];
            sum -= num;
            if (num < sum) return sum + num; 
        }
        return -1;
    }
}