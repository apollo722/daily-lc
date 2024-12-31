/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int n = lists.length;
        int half = (n + 1) / 2;
        int l = 0, r = half;
        while (true) {
            while (l < half && r < n) {
                lists[l] = merge(lists[l], lists[r]);
                l++;
                r++;
            }
            n = half;
            half = (n + 1) / 2;
            l = 0;
            r = half;
            if (n == 1) break;
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode preRes = new ListNode(-1);
        ListNode cur = preRes;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return preRes.next;
    }
}


/*
分治的两两合并链表。
需要注意的是取值和停止条件。
如果n就剩下1了，肯定要停止。在大于1的情况，每次先要找到一半。
之后在半段之前且当前计算长度前停止，并不断更新总长。总长就是上一轮后半段的起点。
*/