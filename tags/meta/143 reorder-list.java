/*
https://leetcode.com/problems/reorder-list/

先找到list的后半部分，之后reverse后半部分，在合并两部分即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHead = slow.next;
        slow.next = null;
        ListNode merge = reverse(revHead);
        merge(head, merge);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode head, ListNode revHead) {
        ListNode cur = head, revCur = revHead;
        while (cur != null && revCur != null) {
            ListNode next = cur.next;
            cur.next = revCur;
            ListNode revNext = revCur.next;
            revCur.next = next;
            revCur = revNext;
            cur = next;
        }
    }
}