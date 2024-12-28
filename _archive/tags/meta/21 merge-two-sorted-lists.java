/*
https://leetcode.com/problems/merge-two-sorted-lists/

合并有序linkedlist模板

Time: O(m+n)
Space: O(1)
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return prehead.next;
    }
}