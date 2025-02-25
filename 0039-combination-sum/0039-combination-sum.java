class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int idx, int curSum, int target, List<Integer> list) {
        if (curSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == candidates.length || curSum > target) return;
        for (int i = idx; i < candidates.length; i++) {
            if (curSum + candidates[i] > target) return;
            list.add(candidates[i]);
            backtrack(candidates, i, curSum + candidates[i], target, list);
            list.remove(list.size() - 1);
        }
    }

}