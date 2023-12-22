/*
https://leetcode.com/problems/combination-sum-ii/

backtrack模板，先把输入排序，之后按照回溯直接求解，注意要去重

Time: O(2^n)
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int idx, int curSum, int target, List<Integer> list) {
        if (curSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == candidates.length) return;
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && i < candidates.length && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] + curSum > target) return;
            list.add(candidates[i]);
            backtrack(candidates, i + 1, curSum + candidates[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}