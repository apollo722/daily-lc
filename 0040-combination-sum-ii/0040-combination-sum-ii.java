class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int idx, int curSum, int target, List<Integer> list) {
        if (target == curSum) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == candidates.length || curSum > target) return;
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] + curSum > target) return;
            list.add(candidates[i]);
            backtrack(candidates, i + 1, curSum + candidates[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}