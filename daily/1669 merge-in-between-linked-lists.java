/*
https://leetcode.com/problems/merge-in-between-linked-lists/

依次找到ab两点，和list2的终点，按题意做链接即可

Time: O(m + n)
Space: O(1)
*/

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode cur = list1, start = null, end = null, list2end = list2;
        while (list2end.next != null) list2end = list2end.next;
        while (idx <= b) {
            if (idx == b) end = cur;
            idx++;
            if (idx == a) start = cur;
            cur = cur.next;
        }
        start.next = list2;
        list2end.next = end.next;
        end.next = null;
        return list1;
    }
}