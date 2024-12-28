/*
https://leetcode.com/problems/remove-linked-list-elements/

用一个dummyhead和prev来track上一个节点
如果当前节点值是val，那么上一个节点直接连到下一个节点，否则只是移动cur和prev

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prevHead = new ListNode();
        prevHead.next = head;
        ListNode cur = head, prev = prevHead;
        while (cur != null) {
            if (cur.val == val) prev.next = cur.next;
            else prev = cur;
            cur = cur.next;
        }
        return prevHead.next;
    }
}