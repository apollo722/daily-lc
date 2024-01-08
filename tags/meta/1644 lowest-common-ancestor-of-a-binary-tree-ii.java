/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/

和其它lca的题一样，只是多了一种p，q不是树中节点的情况
所以只要check一下p，q到底是不是树中节点即可
具体来说，要么p，q是root，要么找到了lca，即变相地说明了p，q存在
三种情况满足任意两种即可（事实上只能最多同时满足两种）
所以多加一个变量，当任何时候满足了两种情况，标记为true
最后返回的时候根据标记变量来返回结果或者null

Time: O(n)
Space: O(n)
*/

class Solution {
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = check(root, p, q);
        return found ? res : null;
    }

    private TreeNode check(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = check(root.left, p, q), right = check(root.right, p, q);
        int cnt = 0;
        if (root == p || root == q) cnt++;
        if (left != null) cnt++;
        if (right != null) cnt++;
        if (cnt >= 2) found = true;
        if ((left != null && right != null) || root == p || root == q) return root;
        if (left != null) return left;
        return right;
    }
}