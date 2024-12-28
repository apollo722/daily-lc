/*
https://leetcode.com/problems/reverse-linked-list-ii/

先找到需要reverse的区间
即找区间起点node的前一个node（prevRevHead），和区间终点node的后一个node（tail）
如果起点node即为head（或者起点前一个node不存在），则从head开始reverse，直到tail
否则reverse prevRevHead.next到tail前一个node
再把reverse好的node接回prevRevHead即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode prevRevHead = null, tail = head;
        int k = 0;
        while (k < right) {
            if (k == left - 2) {
                prevRevHead = tail;
            }
            tail = tail.next;
            k++;
        }
        if (prevRevHead == null) return reverse(head, tail);
        ListNode revHead = reverse(prevRevHead.next, tail);
        prevRevHead.next = revHead;
        return head; 
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