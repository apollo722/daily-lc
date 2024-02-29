/*
https://leetcode.com/problems/even-odd-tree/

level order traverse模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean even = curLevel % 2 == 0 ? true : false;
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (even) {
                    if (cur.val % 2 != 1 || cur.val <= prev) return false;
                } else {
                    if (cur.val % 2 != 0 || cur.val >= prev) return false;
                }
                prev = cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            curLevel++;
        }
        return true;
    }
}