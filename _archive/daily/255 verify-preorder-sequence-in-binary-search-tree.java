/*
https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/

preoder遍历是先root再左右，所以按照顺序遍历数组中元素的时候，会越来越小作为左子树
直到遇到一个较大的元素，是之前某个元素的右子树
找到右子树的父节点之后，接下来的所有元素都要大于左子树的所有元素，这样才能满足bst的定义
所以可以用stack来存储遇到的可能root，构造单调递减栈
遇到大于栈内元素的元素时，连续pop栈首元素，直到找到大于当前元素的元素，最后被pop的元素就应该是那个root节点用来挂载当前元素为其右子树
每次pop的元素都是左子树的部分，即决定了之后元素的下限
所以之后的元素如果有比当前下限还小的元素，就要返回false

用原数组作为存储可以代替stack的空间

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int curMin = Integer.MIN_VALUE;
        int i = 0;
        for (int num : preorder) {
            while (i > 0 && preorder[i - 1] < num) {
                curMin = preorder[i - 1];
                i--;
            }
            if (num <= curMin) return false;
            preorder[i] = num;
            i++;
        }
        return true;
    }
}