/*
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

代码题，扫描所有点，找到第一个和每对相邻的critical point
最小距离就是每对最小的距离，最大距离就是最后与第一个点的距离

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = {-1, -1};
        int min = Integer.MAX_VALUE;
        ListNode prev = head, cur = head.next;
        int curIdx = 1, prevIdx = 0, first = 0;
        while (cur.next != null) {
            if ((cur.val < prev.val && cur.val < cur.next.val) || (cur.val > prev.val && cur.val > cur.next.val)) {
                if (prevIdx == 0) {
                    first = curIdx;
                    prevIdx = curIdx;
                } else {
                    min = Math.min(min, curIdx - prevIdx);
                    prevIdx = curIdx;
                }
            }
            curIdx++;
            prev = cur;
            cur = cur.next;
        }
        if (min != Integer.MAX_VALUE) {
            return new int[]{min, prevIdx - first};
        }
        return res;
    }
}