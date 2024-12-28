/*
https://leetcode.com/problems/rotate-list/

先扫一遍找到全长，之后k对其取余得到真正的k
之后找到倒数k+1的位置，进行重新移动即可
即倒数第k+1个的next连head，之后后面接null，即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode cur = head, secondLast = head;
        while (cur != null) {
            len++;
            if (cur.next == null) secondLast = cur;
            cur = cur.next;
        }
        k = k % len;
        if (k == 0) return head;
        cur = head;
        for (int i = 0; i < len - k - 1; i++) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        secondLast.next = head;
        return res;
    }
}