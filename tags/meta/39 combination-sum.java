/*
https://leetcode.com/problems/combination-sum/

backtrack模板
此题数组中都是不重复的数字
排序可以帮助提前结束递归

Time: O(n^((t/m) + 1))，n为数字个数，t为target大小，m为最小的数
backtrack可以想成对n-ary树的dfs，而平均最深也就是t/m层即可退出
Space: O(t/m)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int idx, int curSum, int tar, List<Integer> list) {
        if (tar == curSum) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == candidates.length || tar < curSum) return;
        for (int i = idx; i < candidates.length; i++) {
            if (curSum + candidates[i] > tar) return;
            list.add(candidates[i]);
            backtrack(candidates, i, curSum + candidates[i], tar, list);
            list.remove(list.size() - 1);
        }
    }
}