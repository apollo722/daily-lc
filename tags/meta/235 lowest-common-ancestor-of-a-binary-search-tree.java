/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

利用BST性质，先把p和q按顺序排好
如果当前root是null或者p或q，直接返回
否则如果root.val比pq二者大者还大，lca一定在左子树
否则在右子树
如果root.val位于二者中间，则root本身就是lca

Time: O(n)
Space: O(h)
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root == null || root.val == q.val || p.val == root.val) return root;
        if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}