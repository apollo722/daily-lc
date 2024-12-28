/*
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

按部就班顺序处理即可
扫描所有节点，如果节点的child不为null，那么先存一下当前节点的next与child
之后找到child list中的最后一个节点，把它与next和cur都连起来
之后置cur.child为null，并继续处理cur.next

Time: O(n)
Space: O(1)
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next, child = cur.child;
                while (child.next != null) child = child.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                child.next = next;
                if (next != null) next.prev = child;
                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }
}