/*
https://leetcode.com/problems/combinations/

backtracking模板

Time: O(Ck_n)，排列的复杂度
Space: O(k)，recursion最多k的深度
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int idx, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}