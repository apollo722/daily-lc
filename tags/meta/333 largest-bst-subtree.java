/*
https://leetcode.com/problems/largest-bst-subtree/

题目不明不白的，要找的是含有最多节点的搜索树子树
既要满足搜索树，也要是子树，不能从root开始
递归的检查每个节点，如果满足搜索树，就返回总结点数，否则，标记成不包含搜索树
利用新建的数据结构记录当前节点子树的最大最小以及节点数情况
逐步的扫完所有节点

Time: O(n)
Space: O(n)
*/

class Solution {
    class Node {
        int min, max, size;
        Node (int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        return calc(root).size;
    }

    private Node calc(TreeNode root) {
        if (root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Node left = calc(root.left), right = calc(root.right);
        if (left.max < root.val && root.val < right.min) return new Node(
            Math.min(root.val, left.min),
            Math.max(root.val, right.max),
            left.size + right.size + 1
        );
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
}