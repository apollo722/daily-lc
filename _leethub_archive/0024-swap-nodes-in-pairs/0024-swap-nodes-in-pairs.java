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
    public ListNode swapPairs(ListNode head) {
        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;
        ListNode prev = prevHead;
        while (head != null && head.next != null) {
            ListNode first = head, second = head.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            head = first.next;
            prev = first;
        }
        return prevHead.next;
    }
}


/*
逐对交换的iterative算法。
首先需要prev来时刻追踪head的前一个，因为prev.next要挂在交换后的第二个节点。
假设当前处理的节点是first，它后面的就是second，要先把他们交换。
second肯定要挂在prev后，而first后面挂的是原本second的next节点。
之后second后面接着first。
最后移动head到first的下一个，prev顺序移动到head。
记忆的话就按照prev，first，second这个顺序处理每一个节点的next。
*/