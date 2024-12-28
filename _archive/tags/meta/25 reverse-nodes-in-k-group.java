/*
https://leetcode.com/problems/reverse-nodes-in-k-group/

进阶版reverse linkedlist
除了第一个reverse的head是结果之外，每次找k个节点之后reverse，reverse后的head要连接到prev的next上
reverse k个与全reverse的区别就是全reverse要reverse到null的位置，而k个只需要reverse到tail的位置

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode res = head, cur = head, prev = new ListNode(-1);
        while (cur != null) {
            ListNode tail = cur;
            int i = 0;
            while (tail != null && i < k) {
                tail = tail.next;
                i++;
            }
            if (i == k) {
                if (cur == head) {
                    res = reverse(cur, tail);
                } else {
                    prev.next = reverse(cur, tail);
                }
            }
            prev = cur;
            cur = tail;
        }
        return res;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head, prev = tail;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}