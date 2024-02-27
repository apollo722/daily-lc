/*
https://leetcode.com/problems/symmetric-tree/

dfs逐个对称检查，类似100
即如果两个节点同时为null，为true
任何一个为null，证明另一个不为null，即为false
在当前节点值相等的情况下继续检查左节点的右孩子与右节点的左孩子，和左节点的左孩子与右节点的右孩子是否都相等

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }
}