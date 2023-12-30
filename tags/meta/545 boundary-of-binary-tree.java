/*
https://leetcode.com/problems/boundary-of-binary-tree/

如果是前序遍历，树的左半边顺序即是所求，右半边是反过来的
所以按照前序遍历的想法做，只是把右半边的顺序反过来
遍历的时候时刻记录当前的节点是不是boundary，具体来说：
如果是根节点，那么左右子节点都一定是boundary
一个左边界左子节点一定是边界，如果没有左子节点，那右子节点一定是边界
反之，右边界的右子节点一定是边界，如果没有右子节点，那左子节点一定是边界
如果是叶节点一定是边界
其余的都只是普通节点

所以利用一个变量来记录当前节点是什么属性，-1为左边界，1为右边界
之后左边界在前序加入结果，右边界在后序加入结果

Time: O(n)
Space: O(n)
*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        dfs(root.left, -1);
        dfs(root.right, 1);
        return res;
    }

    private void dfs(TreeNode root, int side) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        int l = 0, r = 0;
        if (side == -1) {  // 当前为左边界
            l = root.left == null ? 0 : -1;  // 存在左子节点，那么左子节点标记为左边界
            r = l == 0 ? -1 : 0;  // 如果不存在左子节点，那么右子节点标记为左边界
            res.add(root.val);  // 前序加入左边界
        }
        if (side == 1) {  // 当前为右边界
            r = root.right == null ? 0 : 1;  // 存在右子节点，那么右子节点标记为右边界
            l = r == 0 ? 1 : 0;  // 如果不存在右子节点，那么左子节点标记为右边界
        }
        dfs(root.left, l);
        dfs(root.right, r);
        if (side == 1) {
            res.add(root.val);  // 后序加入右边界
        }
    }
}