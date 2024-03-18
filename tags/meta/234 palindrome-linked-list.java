/*
https://leetcode.com/problems/palindrome-linked-list/

linkedlist找中点+reverse linkedlist模板
先找到中点，之后reverse后半段，再逐个比较

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHead = reverse(slow.next);
        ListNode i = head, j = revHead;
        while (i != null && j != null) {
            if (i.val != j.val) return false;
            i = i.next;
            j = j.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}