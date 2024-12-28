/*
https://leetcode.com/problems/binary-tree-paths/

递归的处理每一条线即可
实际上用list来回溯，并用StringBuilder拼接可能效率会更高
不断地用String去复制运行会慢，空间消耗也更大

Time: O(n)
Space: O(n)
*/

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String cur) {
        if (root == null) return;
        cur += root.val + "";
        if (root.left == null && root.right == null) {
            res.add(cur);
            return;
        }
        cur += "->";
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}