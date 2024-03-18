/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/

层序遍历模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size(), len = size;
            double sum = 0;
            while (size-- > 0) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(sum / (1.0 * len));
        }
        return res;
    }
}