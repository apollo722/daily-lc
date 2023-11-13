/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

用两个node分别记录相隔为n的点
先移动fast node到第n个
如果此时fast node已经是null了，证明删除的是第一个node
否则移动fast node直到fast是最后一个（fast.next != null）
此时slow node的next即倒数第n个


Time: O(n)
Space: O(1)
*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        while (n-- > 0) fast = fast.next;
        if (fast == null) {
            ListNode res = head.next;
            head.next = null;
            return res;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}