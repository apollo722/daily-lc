/*
https://leetcode.com/problems/balance-a-binary-search-tree/

用inorder先把整个树按照顺序摊平，这样获得有序的数组
之后每次从中点建树即可以使得树是balance的

Time: O(n)
Space: O(n)
*/

class Solution {
    List<Integer> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        inorderTraversal(root);
        return build(0, arr.size() - 1);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        arr.add(root.val);
        inorderTraversal(root.right);
    }

    private TreeNode build(int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(arr.get(l));
        int mid = l + (r - l) / 2;
        TreeNode res = new TreeNode(arr.get(mid));
        res.left = build(l, mid - 1);
        res.right = build(mid + 1, r);
        return res;
    }
}