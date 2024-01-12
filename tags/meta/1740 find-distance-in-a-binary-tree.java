/*
https://leetcode.com/problems/find-distance-in-a-binary-tree/

先找到二者的公共祖先
之后从公共祖先分别找到两个节点的位置并计算经过的距离，距离和即为答案

Time: O(n)
Space: O(n)
*/

class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lcaNode = lca(root, p, q);
        return find(lcaNode, p, 0) + find(lcaNode, q, 0);
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = lca(root.left, p, q), right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    private int find(TreeNode root, int p, int cur) {
        if (root == null) return -1;
        if (root.val == p) return cur;
        int left = find(root.left, p, cur + 1);
        return left == -1 ? find(root.right, p, cur + 1) : left;
    }
}