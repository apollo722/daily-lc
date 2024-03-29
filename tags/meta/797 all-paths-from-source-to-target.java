/*
https://leetcode.com/problems/all-paths-from-source-to-target/

backtracking模板

Time: O(2^n n)
Space: O(n)
*/

class Solution {
    int[][] g;
    int tar;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        tar = graph.length - 1;
        res = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(0);
        backtrack(0, list);
        return res;
    }

    private void backtrack(int cur, List<Integer> list) {
        if (cur == tar) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next : g[cur]) {
            list.add(next);
            backtrack(next, list);
            list.removeLast();
        }
    }
}