/*
https://leetcode.com/problems/odd-even-linked-list/

分别用两个ptr处理odd与even，最后将二者链接即可
注意原链表长度可以是奇数也可以是偶数，所以终止条件要注意是even!=null且even.next!=null
奇数节点的next应该连接到偶数节点的下一个
反之同理

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}