/*
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

BFS先找到最底层的第一个和最后一个节点
如果第一个和最后一个节点是同一个节点，则直接返回
再通过LCA来找到他们最低公共祖先

Time: O(n)，BFS和LCA都是O(n)
Space: O(n)
*/

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode first = null, last = null;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) first = cur;
                if (i == size - 1) last = cur;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        if (first == last) return first;
        return lca(root, first, last);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}