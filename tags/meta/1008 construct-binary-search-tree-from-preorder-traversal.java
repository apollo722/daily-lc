/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

因为是前序，所以处理的每一个都是root，其下一个一定是左子节点，直到第一个大于当前值的位置
所以每次找到第一个更大的位置，即为又子树，否则当前位置和更大位置之间都是左子树
递归构建即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] arr, int l, int r) {
        if (l > r) return null;
        TreeNode node = new TreeNode(arr[l]);
        int mid = l + 1;
        while (mid < arr.length && arr[mid] <= arr[l]) mid++;
        node.left = build(arr, l + 1, mid - 1);
        node.right = build(arr, mid, r);
        return node;
    }
}