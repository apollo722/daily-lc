/*
https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

分如下几种情况：
1. 输入为null，按照题意，返回一个self linked node
2. 输入只有一个节点，插入一个新节点并且该节点接回输入节点，返回输入节点
3.a 任何时候，如果val落入前节点和当前节点之间，可以直接插入
3.b 已经套圈，即prev > cur了，那么不论val大于prev还是小于cur，都可以插入到二者之间
3.c 当prev重新回到head的位置，证明已经走过一圈，而如上情况都没有发生，证明所有节点都是相等的，且val不是相等的值，那么随便插入一个位置即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }
        Node prev = head, cur = head.next;
        if (prev == cur) return getRes(head, prev, cur, insertVal);
        while (true) {
            int prevVal = prev.val, curVal = cur.val;
            if (prevVal <= insertVal && insertVal <= curVal) return getRes(head, prev, cur, insertVal);
            else if (curVal < prevVal && prevVal <= insertVal || insertVal <= curVal && curVal < prevVal) return getRes(head, prev, cur, insertVal);
            prev = prev.next;
            cur = cur.next;
            if (prev == head) break;
        }
        return getRes(head, prev, cur, insertVal);
    }

    private Node getRes(Node head, Node prev, Node cur, int val) {
        Node res = new Node(val);
        prev.next = res;
        res.next = cur;
        return head;
    }
}