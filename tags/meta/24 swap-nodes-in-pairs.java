/*
https://leetcode.com/problems/swap-nodes-in-pairs/

成对处理每一对节点
每次分别记住nextNext和next
之后把cur.next.next链接cur，cur.next链接nextNext
如果前一对的尾不是null，把它链接next
之后把队尾置成cur，之后移动cur
最后返回处理前就置好的head.next

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, res = head.next, prev = null;
        while (cur != null && cur.next != null) {
            ListNode nextNext = cur.next.next;
            ListNode next = cur.next;
            cur.next.next = cur;
            cur.next = nextNext;
            if (prev != null) prev.next = next;
            prev = cur;
            cur = nextNext;
        }
        return res;
    }
}