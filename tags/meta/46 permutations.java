/*
https://leetcode.com/problems/permutations/

backtracking模板

Time: O(n n!)，第一个n是用来copy answer到res中的，随后的n阶乘是backtracking复杂度
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int mask, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ( ((1 << i) & mask) != 0) continue;
            mask |= (1 << i);
            list.add(nums[i]);
            backtrack(nums, mask, list);
            list.removeLast();
            mask &= (~(1 << i));
        }
    }
}