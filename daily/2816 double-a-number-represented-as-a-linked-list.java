/*
https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/

可以先reverse，之后计算，之后再reverse回来
但再进一步，可以发现前一个节点最多也就多1
比如999，也就变成1998，即一旦知道下一个位置是否需要进位，前一个节点只需要+=1就够了
所以只需要建立一个节点连到当前head上，之后顺序扫描节点和其前面的节点
如果当前节点乘以2大于等于10，前面的节点值+=1即可
因为一个节点值乘以2之后，后面是否对当前节点有进位并不影响再往前的节点
因为最多进1，所以最大的不能进的情况是2x4+1=9，最小的是2x5+1=11，两种情况后面是什么前面都不受影响

Time: O(n)
Space: O(1)
*/

class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode addHead = new ListNode(0);
        addHead.next = head;
        ListNode prev = addHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val * 2 >= 10) prev.val++;
            cur.val = (cur.val * 2) % 10;
            prev = prev.next;
            cur = cur.next;
        }
        return addHead.val > 0 ? addHead : head;
    }
}