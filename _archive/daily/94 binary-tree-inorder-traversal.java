/*
https://leetcode.com/problems/binary-tree-inorder-traversal/

traverse算法

Time: O(n)
Space: O(h)，worst O(n)
*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}