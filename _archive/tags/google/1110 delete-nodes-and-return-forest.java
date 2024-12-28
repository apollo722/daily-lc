/*
https://leetcode.com/problems/delete-nodes-and-return-forest/

递归遍历，先处理root，如果root本身不被删除，先加到结果中
递归处理每一个节点
如果当前节点需要被删除，首先返回值应该是null，因为从上面递归到此要把当前节点删掉，即置为null
之后看左右节点是不是也要被删除，如果不被删除，那么直接放到结果中

如果当前结果不被删除，那么递归处理左右子树即可

Time: O(n)
Space: O(n)
*/

class Solution {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return res;
        HashSet<Integer> s = new HashSet<>();
        for (int num : to_delete) s.add(num);
        if (!s.contains(root.val)) res.add(root);
        process(root, s);
        return res;
    }

    private TreeNode process(TreeNode node, HashSet<Integer> s) {
        if (node == null) return null;
        TreeNode resNode = node;
        if (s.contains(node.val)) {
            if (node.left != null && !s.contains(node.left.val)) res.add(node.left);
            if (node.right != null && !s.contains(node.right.val)) res.add(node.right);
            resNode = null;
        }
        node.left = process(node.left, s);
        node.right = process(node.right, s);
        return resNode;
    }
}