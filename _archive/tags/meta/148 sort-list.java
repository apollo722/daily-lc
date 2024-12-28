/*
https://leetcode.com/problems/sort-list/

merge sort
注意每次找到list中点之后要把中点前.next置于null

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(), cur = res;
        while (l1 != null && l2 != null) {
            int d1 = l1.val, d2 = l2.val;
            if (d1 < d2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return res.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head, midPrev = null;
        while (fast != null && fast.next != null) {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}