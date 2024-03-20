/*
https://leetcode.com/problems/cousins-in-binary-tree/

dfs遍历所有节点，找到目标是分别标记其所在层和parent，最后比较即可

Time: O(n)
Space: O(n)
*/

class Solution {
    int px = 0, py = 0, lx = -1, ly = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, -1);
        if (lx == ly && px != py) return true;
        return false;
    }

    private void dfs(TreeNode node, int x, int y, int level, int parent) {
        if (node == null) return;
        if (px != 0 && py != 0) return;
        if (node.val == x) {
            lx = level;
            px = parent;
        }
        if (node.val == y) {
            ly = level;
            py = parent;
        }
        dfs(node.left, x, y, level + 1, node.val);
        dfs(node.right, x, y, level + 1, node.val);
    }
}