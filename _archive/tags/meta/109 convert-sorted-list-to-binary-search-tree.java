/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

利用中序遍历的有序特性递归的处理树的每一个节点
为了保证树是平衡二叉树，每次要从中间节点截断
故一开始要知道树的size，之后二分
维护一个全局ptr来追踪从head开始到目前处理到哪里
每次消耗一个节点，全局ptr就向后移动
这样中序遍历的位置和全局ptr的位置是统一的

Time: O(n)
Space: O(logn)
*/

class Solution {
    private int size(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            cur = cur.next;
            res++;
        }
        return res;
    }

    ListNode curNode;

    private TreeNode convert(int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode left = convert(l, mid - 1);
        TreeNode node = new TreeNode(curNode.val);
        node.left = left;
        curNode = curNode.next;
        node.right = convert(mid + 1, r);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = size(head);
        this.curNode = head;
        return convert(0, size - 1);
    }
}