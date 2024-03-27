/*
https://leetcode.com/problems/intersection-of-two-linked-lists/

因为两个链表一定有交点，就相当于ab两个链表会有share的tail
比如headA是a+c，headB是b+c，shared tail是c
那么a+c+b == b+c+a
所以从二者头向下走，都走完a+b+c之后停下的位置就是tail的起点
即分别从头走，任何一个链表走到头之后再接着从另一条走，知道找到二者相等的节点

Time: O(n+m)
Space: O(1)
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}