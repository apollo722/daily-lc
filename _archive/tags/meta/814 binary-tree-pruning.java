/*
https://leetcode.com/problems/binary-tree-pruning/

递归求解每一个节点
如果节点和子树都不含1，返回false，否则返回true
返回false的枝要置为null

Time: O(n)
Space: O(n)
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (process(root)) return root;
        return null;
    }

    private boolean process(TreeNode root) {
        if (root == null) return false;
        boolean left = process(root.left);
        if (!left) root.left = null;
        boolean right = process(root.right);
        if (!right) root.right = null;
        return left || right || root.val == 1;
    }
}