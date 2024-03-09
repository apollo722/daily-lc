/*
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

用stack来inorder transverse
边遍历边merge
每次先找到两棵树当前节点的左下node，即st inorder遍历的写法，之后根据元素存在以及大小情况来决定将谁放入结果
放入结果后的节点要在st中pop出，并将ptr置于其右子树，循环直到两个子树都为空或者st中再无元素

Time: O(m + n)
Space: O(m + n)
*/

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>(), st2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root1 != null || root2 != null || !st1.isEmpty() || !st2.isEmpty()) {
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.left;
            }
            if (st2.isEmpty() || !st1.isEmpty() && st1.peek().val <= st2.peek().val) {
                root1 = st1.pop();
                res.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = st2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}