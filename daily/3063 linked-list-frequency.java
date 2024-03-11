/*
https://leetcode.com/problems/linked-list-frequency/

用一个map存储int对应的node
扫描输入，遇到新的int时装入map，并链接结果的上一个节点
否则找到对应的节点并++

Time: O(n)
Space: O(n)
*/

class Solution {
    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer, ListNode> m = new HashMap<>();
        ListNode cur = head, res = new ListNode(0), curRes = res;
        while (cur != null) {
            int num = cur.val;
            if (!m.containsKey(num)) {
                curRes.next = new ListNode(1);
                m.put(num, curRes.next);
                curRes = curRes.next;
            } else m.get(num).val++;
            cur = cur.next;
        }
        return res.next;
    }
}