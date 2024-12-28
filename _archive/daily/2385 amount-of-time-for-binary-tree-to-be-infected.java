/*
https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

如果start恰好是root，那么左右两子树的最大深度就是结果
如果start不是root呢？从start开始的subtree，仍然是正常的计算depth，子树中较大者是最后结果的备选
找到start的时候，标记为-1，用以标记找到了目标节点
如果一个子树不含有负数depth，证明当前子树不含有start，深度依然正常计算
如果一个节点的子树含有负数节点，证明它的子树含有start，那么此节点感染长度就是两子树绝对值的和
递归的时候track整体最长的路径
对于含有start的子树，它的depth是负数，即min(left,right)-1，left和right中不论哪个是-1，总之结果是更小的负数

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return res;
    }

    private int dfs(TreeNode root, int start) {
        if (root == null) return 0;
        int depth = 0;
        int left = dfs(root.left, start), right = dfs(root.right, start);
        if (root.val == start) {
            res = Math.max(left, right);
            depth = -1;
        } else if (left >= 0 && right >= 0) {
            depth = Math.max(left, right) + 1;
        } else {
            int dist = Math.abs(left) + Math.abs(right);
            res = Math.max(res, dist);
            depth = Math.min(left, right) - 1;
        }
        return depth;
    }
}