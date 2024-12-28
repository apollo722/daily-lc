'''
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

从右子树开始遍历即可
每次的根节点都是当前为止的sum

Time: O(n)
Space: O(n)
'''

class Solution:
    sum = 0
    def bstToGst(self, root: TreeNode) -> TreeNode:
        self.convert(root)
        return root

    def convert(self, root):
        if root is None:
            return
        self.convert(root.right)
        self.sum += root.val
        root.val = self.sum
        self.convert(root.left)