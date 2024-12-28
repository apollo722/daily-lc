/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

level order traversal模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            if (flag) Collections.reverse(list);
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}