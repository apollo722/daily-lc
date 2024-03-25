/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/

BFS与DFS都可以，只不过BFS一旦找到任何一个叶节点就停了，DFS会扫完整棵树

Time: O(n)
Space: O(n)
*/

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) return res;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return res;
    }
}