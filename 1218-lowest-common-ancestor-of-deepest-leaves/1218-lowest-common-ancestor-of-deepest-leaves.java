/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        TreeNode candidate1 = root, candidate2 = root;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) candidate1 = cur;
                if (i == size - 1) candidate2 = cur;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return lca(root, candidate1, candidate2);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) return p;
        if (root == null || root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q), right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left == null) return right;
        return left;
    }
}