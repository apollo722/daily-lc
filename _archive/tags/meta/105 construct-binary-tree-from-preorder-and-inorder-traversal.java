/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

先用map把inorder的数值和idx对应起来
之后按照preorder顺序，对每个节点递归的构建树
构建的时候找到inorder对应的idx，这样idx左边的部分就是左子树，反之亦然

Time: O(n)
Space: O(n)
*/

class Solution {
    int cur = 0;
    HashMap<Integer, Integer> m = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) m.put(inorder[i], i);
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        if (cur == preorder.length) return null;
        TreeNode root = new TreeNode(preorder[cur++]);
        int idx = m.get(root.val);
        root.left = build(preorder, inorder, start, idx - 1);
        root.right = build(preorder, inorder, idx + 1, end);
        return root;
    }
}