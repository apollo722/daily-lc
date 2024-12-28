/*
https://leetcode.com/problems/find-bottom-left-tree-value/

BFS，只是每次先装右再装左，最后一个记录的就是结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            res = cur.val;
            if (cur.right != null) q.add(cur.right);
            if (cur.left != null) q.add(cur.left);
        }
        return res;
    }
}