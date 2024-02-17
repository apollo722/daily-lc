/*
https://leetcode.com/problems/print-immutable-linked-list-in-reverse/

recursive或者stack来找到最后一个，反着打印即可
有一些有趣的算法可以减少空间复杂度：https://leetcode.com/problems/print-immutable-linked-list-in-reverse/editorial/

Time: O(n)
Space: O(n)
*/

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head != null) {
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}