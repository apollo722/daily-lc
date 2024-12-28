/*
https://leetcode.com/problems/closest-binary-search-tree-value/

递归的检查节点，如果当前结果与tar的差大于当前节点
或者差一样但是当前节点值更小，那就把结果更新为当前节点
之后根据当前节点的值与tar的值的大小来看检查左还是右子树

Time: O(n)
Space: O(n)
*/

class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            int curVal = root.val;
            res = Math.abs(curVal - target) < Math.abs(res - target) 
                || (Math.abs(curVal - target) == Math.abs(res - target) && curVal < res) ? curVal : res;
            root = target < curVal ? root.left : root.right;
        }
        return res;
    }
}