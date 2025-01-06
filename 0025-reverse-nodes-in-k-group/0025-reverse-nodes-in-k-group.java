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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode res = null, prev = null, cur = head;
        while (cur != null) {
            ListNode tail = cur;
            int i = 0;
            while (tail != null && i < k) {
                tail = tail.next;
                i++;
            }
            if (i < k) break;
            if (res == null) {
                res = reverse(cur, tail);
            } else prev.next = reverse(cur, tail);
            prev = cur;
            cur = tail;
        }
        return res;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == tail) return tail;
        ListNode prev = tail, cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}


/*
题目可以看成两部分，一是实现一个翻转单元来翻转任意一段链表，二是把翻转的部分连起来。
第一部分比较好实现。较常规的翻转链表，只需要把停止条件从null变成tail。即翻转起点到tail之前节点的一段。

第二部分是要看如何将第一部分每个k的翻转单元连起来。
首先处理一下corner case，即k为1的情况，直接返回即可。
链接每一个翻转单元，肯定需要上一个翻转部分的尾部节点，用来连接下一个翻转单元的头节点。
其中，第一个翻转单元的结果要作为整体问题的返回。
接下来就要找到每个k段作为翻转单元。朴素的在tail不为null的情况数k个节点即可。
之后即用第一部分实现的翻转函数翻转这一段链表。并且把返回的头节点连在接在上一段的尾节点后面。
上一段的尾节点是什么呢？就是上一段一开始的头啊，因为翻转了之后头就变尾了。
所以除了第一段翻转之后的结果要作为最终结果返回，其后的每一段都要把翻转后的头与下一段的结果相连。
注意不足k的部分是不用反转的，所以查k个节点如果已经遇到了null的情况，要处理。
tail为null的时候这里不能直接退出，因为可能刚好链表长度是k，第一组翻转的时候k刚好在最后为null。
所以只能用k来做翻转条件，即查到了k个节点就翻转。
*/