/*
https://leetcode.com/problems/winner-of-the-linked-list-game/

每次比较两个node，跳两个node即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public String gameResult(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (cur.val < cur.next.val) res--;
            else if (cur.val > cur.next.val) res++;
            cur = cur.next.next;
        }
        if (res > 0) return "Even";
        else if (res < 0) return "Odd";
        return "Tie";
    }
}