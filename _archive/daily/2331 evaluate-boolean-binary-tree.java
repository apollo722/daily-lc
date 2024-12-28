/*
https://leetcode.com/problems/evaluate-boolean-binary-tree/

递归dfs模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return root.val == 1;
        if (root.val == 2) return evaluateTree(root.left) || evaluateTree(root.right);
        else return evaluateTree(root.left) && evaluateTree(root.right);
    }
}