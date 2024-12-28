/*
https://leetcode.com/problems/path-sum-ii/

dfs+回溯，每次遇到节点，加入list
当节点是叶节点且此时的sum是target时，把list加入节点
否则继续dfs直到遇到叶节点
每次处理完节点回溯时，移除list中最后一个节点即可

Time: O(n^2)，copy list到结果最坏可能take O(n)
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int curSum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && curSum - root.val == 0) {
            res.add(new ArrayList<>(list));
        } else {
            dfs(root.left, curSum - root.val, list);
            dfs(root.right, curSum - root.val, list);
        }
        list.remove(list.size() - 1);
    }
}