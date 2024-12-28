/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

与19类似，通过两个ptr来找到倒数第k个位置
先扫描k次（实际是k-1次，因为idx从1开始），找到第k个位置，记录下值与节点
后继续向后扫描，同时用一个从头开始的ptr来向后扫描，等第一个ptr到结尾时，第二个ptr即为倒数第k个
交换二者值即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        while (--k > 0) {
            fast = fast.next;
        }
        int firstK = fast.val;
        ListNode slow = head, copyFast = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        copyFast.val = slow.val;
        slow.val = firstK;
        return head;
    }
}