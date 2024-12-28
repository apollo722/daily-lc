/*
https://leetcode.com/problems/remove-nodes-from-linked-list/

最后的结果相当于是形成一个单调递减的list，可以用stack，也可以直接recursion
也可以先reverse整个list，之后记录当前最大的节点，任何小于当前最大的节点都跳过
最后再reverse整个list


class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = removeNodes(head.next);
        if (head.val < next.val) return next;
        head.next = next;
        return head;
    }
}

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int curMax = 0;
        ListNode prev = null, cur = head;
        while (cur != null) {
            curMax = Math.max(curMax, cur.val);
            if (cur.val < curMax) {
                prev.next = cur.next;
                ListNode delete = cur;
                cur = cur.next;
                delete.next = null;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}