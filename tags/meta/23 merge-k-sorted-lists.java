/*
https://leetcode.com/problems/merge-k-sorted-lists/

分治算法
对于原数组，可以每次将后半段和前半段的链表合并，这样每次长度会减少一半
比如：
l0 -> l1 -> l2 -> l3 -> l4 
merge[l0, l3], [l1, l4]
l0 -> l1 -> l2
merge[l0, l2]
l0 -> l1
merge[l0, l1]

所以每次只要找到后一半的起点，之后和前面两两合并，并将结果存到前半段即可
这里要注意如何找到后半段的起点（(n+1)/2，inclusive边界的话即+2），以及到最后的终止条件（长度大于0）

Time: O(nlogk)，n是total number of nodes，k是lists.length
Space: O(1)
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int n = lists.length - 1, l = 0, r = (n + 2) / 2;  // inclusive边界，长度是n+1，所以计算是n+2
        while (n > 0) {
            int len = r - 1;  // 下一步的终点是r - 1，即长度是r
            while (r <= n) {
                lists[l] = merge(lists[l], lists[r]);
                r++;
                l++;
            }
            l = 0;
            r = (len + 2) / 2;  // 长度是len+1，所以计算是len+2
            n = len;  // 剩余要处理的元素个数
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode prevRes = new ListNode(-1), cur = prevRes;
        while (l1 != null && l2 != null) {
            int d1 = l1.val, d2 = l2.val;
            if (d1 < d2) {
                l1 = l1.next;
                cur.next = new ListNode(d1);
            } else {
                l2 = l2.next;
                cur.next = new ListNode(d2);
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return prevRes.next;
    }
}