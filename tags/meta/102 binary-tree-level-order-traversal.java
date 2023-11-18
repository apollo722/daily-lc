/*
https://leetcode.com/problems/binary-tree-level-order-traversal/

标准BFS level traversal

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                l.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(l);
        }
        return res;
    }
}