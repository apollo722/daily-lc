/*
https://leetcode.com/problems/missing-ranges/

逐个元素扫描，如果不连续，就把缺少的元素range加入res
包括lower和upper到数组头尾的range也要一并加入

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            res.add(Arrays.asList(lower, upper));
            return res;
        }
        if (lower < nums[0]) res.add(Arrays.asList(lower, nums[0] - 1));
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                res.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if (nums[n - 1] < upper) res.add(Arrays.asList(nums[n - 1] + 1, upper));
        return res;
    }
}