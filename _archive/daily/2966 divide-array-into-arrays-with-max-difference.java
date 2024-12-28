/*
https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/

排序后逐个检查第一和第三位的插值是否小于等于k即可
排序也可以用桶排序提高时间复杂度

Time: O(nlogn)
Space: O(logn)，排序所需的space，不算输出的space
*/

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        for (int i = 0; i < n; i += 3) {
            if (nums[i] + k < nums[i + 2]) return new int[0][0];
            int idx = i / 3;
            res[idx][0] = nums[i];
            res[idx][1] = nums[i + 1];
            res[idx][2] = nums[i + 2];
        }
        return res;
    }
}