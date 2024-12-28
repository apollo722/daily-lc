/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/

标准BFS level traversal

Time: O(n)
Space: O(w)，w为tree最大宽度
*/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode cur = q.poll();
                max = Math.max(cur.val, max);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}