/*
https://leetcode.com/problems/delete-node-in-a-linked-list/

非常差劲的一道题
实际上是没有办法真的删掉当前的node，只能把后一个node删掉，再把当前node值换成下个node的值来达到值转移

Time: O(1)
Space: O(1)
*/

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode nextNext = node.next.next;
        node.next.next = null;
        node.next = nextNext;
    }
}