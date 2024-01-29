/*
https://leetcode.com/problems/subsets-ii/

排序后的backtracking模板

Time: O(n 2^n)
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> list) {
        if (idx > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.removeLast();
        }
    }
}