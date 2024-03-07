/*
https://leetcode.com/problems/middle-of-the-linked-list/

标准快慢ptr找中点

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}