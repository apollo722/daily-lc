/*
https://leetcode.com/problems/partition-list/

用两个node分别挂小于与大于等于的node，最后再合并即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1), large = new ListNode(-1), curSmall = small, curLarge = large;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curLarge.next = null;
        curSmall.next = large.next;
        return small.next;
    }
}