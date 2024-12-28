/*
https://leetcode.com/problems/add-two-numbers/

Time: O(max(m, n))
Space: O(max(m, n))
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(), cur = res;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int total = d1 + d2 + carry;
            int d = total % 10;
            carry = total / 10;
            cur.next = new ListNode(d);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) cur.next = new ListNode(1);
        return res.next;
    }
}