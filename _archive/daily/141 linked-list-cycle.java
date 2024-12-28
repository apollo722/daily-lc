/*
https://leetcode.com/problems/linked-list-cycle/

快慢ptr，如果追上了就有环，否则就没有

Time: O(n)
Space: O(1)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}