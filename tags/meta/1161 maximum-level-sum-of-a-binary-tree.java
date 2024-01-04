/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

level order traversal模板

Time: O(n)
Space: O(w)
*/

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int res = -1, max = Integer.MIN_VALUE, level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            level++;
            int size = q.size(), curSum = 0;
            while (size-- > 0) {
                TreeNode cur = q.poll();
                curSum += cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            if (curSum > max) {
                max = curSum;
                res = level;
            }
        }
        return res;
    }
}