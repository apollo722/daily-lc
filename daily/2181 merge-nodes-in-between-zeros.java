/*
https://leetcode.com/problems/merge-nodes-in-between-zeros/

代码题，two ptr直接分段累加并赋值即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p1 = head, p2 = head.next;
        while (p2 != null) {
            int sum = 0;
            while (p2.val != 0) {
                sum += p2.val;
                p2 = p2.next;
            }
            p1.val = sum;
            p2 = p2.next;
            if (p2 == null) {
                p1.next = null;
                break;
            }
            p1 = p1.next;
        }
        return head;
    }
}