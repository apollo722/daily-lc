/*
https://leetcode.com/problems/copy-list-with-random-pointer/

用map可以以O(n) space来做到复制
O(1) space解法：
先扫描一遍输入，把所有的node复制一遍，并插到原node后面
第二遍扫描，node.next.random = node.random.next，如果node.random不为null的话
这是因为现在每个node后面的节点都是复制的，所以如果node.random存在，那么它后面的复制节点的random，就应该是node.random的下一个复制节点
第三遍扫描即把原链表和复制链表分开即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node oldHead = head, res = head.next;
        cur = res;
        while (oldHead != null) {
            oldHead.next = cur.next;
            cur.next = cur.next == null ? null : oldHead.next.next;
            oldHead = oldHead.next;
            cur = cur.next;
        }
        return res;
    }
}