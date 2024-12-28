/*
https://leetcode.com/problems/subsets/

backtracking问题模板

Time: O(n*2^n)
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}