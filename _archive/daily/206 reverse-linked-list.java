/*
https://leetcode.com/problems/reverse-linked-list/

基础模板反转linkedlist，记住它

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode reverseList(ListNode head) {
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
}