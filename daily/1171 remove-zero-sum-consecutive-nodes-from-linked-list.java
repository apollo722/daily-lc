/*
https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

用map把presum的节点都存起来，之后如果同一个presum出现过，那么把当前的next置为出现过的next即可
这里的trick是在存储时同样的presum总是更新最后一个位置，比如[1,3,2,-2,-3]
1 4 6 4 1
虽然两个4可以先删除一波，但是两个1把之间囊括了，相当于直接把最外层删掉了

Time: O(n)
Space: O(n)
*/

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode prev = new ListNode(0, head), cur = prev;
        int sum = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        m.put(0, prev);
        while (cur != null) {
            sum += cur.val;
            m.put(sum, cur);
            cur = cur.next;
        }
        sum = 0;
        cur = prev;
        while (cur != null) {
            sum += cur.val;
            cur.next = m.get(sum).next;
            cur = cur.next;
        }
        return prev.next;
    }
}