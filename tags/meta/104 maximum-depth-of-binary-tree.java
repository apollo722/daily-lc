/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/

dfs递归检查每个节点，当前节点的最大深度为左右子树深度的较大值+1

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maxDepth(TreeNode root) {
        return height(root);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}