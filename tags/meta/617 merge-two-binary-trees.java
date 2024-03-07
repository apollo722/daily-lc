/*
https://leetcode.com/problems/merge-two-binary-trees/

递归处理节点和左右子树
如果节点在两棵树都存在，直接把一棵树的值加到另一颗上
之后左右子节点分别递归调用形成新树
如果任何一个是null，返回另一棵树的节点即可

Time: O(n)
Space: O(n)
*/

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}