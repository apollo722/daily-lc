/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

如果root是null或者root已经等于p或者q，直接返回root
recursive先找左边，再找右边
如果两边结果都不为null，root一定是结果
否则，return不为null的一边

Time: O(n)
Space: O(h)，worst情况是O(n)
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }
}