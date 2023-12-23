/*
https://leetcode.com/problems/diameter-of-n-ary-tree/

递归的计算每一个子节点的高度，那么当前节点的高度即为子节点高度+1
这里的高度指的是边的长度，比如叶节点高度就是0
所以找到最大的diameter就是找到拥有最大高度的两个子节点，并求和

Time: O(n)
Space: O(h)
*/

class Solution {
    int res = 0;
    public int diameter(Node root) {
        getHeight(root);
        return res;
    }

    private int getHeight(Node root) {
        if (root == null) return 0;
        if (root.children.size() == 0) return 0;
        int max1 = 0, max2 = 0;
        for (Node child : root.children) {
            int curHeight = getHeight(child) + 1;
            if (curHeight > max1) {
                max2 = max1;
                max1 = curHeight;
            } else if (curHeight > max2) max2 = curHeight;
            int dist = max1 + max2;
            res = Math.max(res, dist);
        }
        return max1;
    }
}