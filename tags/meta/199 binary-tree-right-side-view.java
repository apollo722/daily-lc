/*
https://leetcode.com/problems/binary-tree-right-side-view/

标准BFS level traversal

Time: O(n)
Space: O(d)，tree diameter，最worst不超过n/2
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                if (size == 0) res.add(cur.val);
            }
        }
        return res;
    }
}