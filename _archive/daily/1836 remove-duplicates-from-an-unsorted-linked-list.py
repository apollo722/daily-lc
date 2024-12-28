'''
https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/

扫两遍，只保留频率等于1的即可

Time: O(n)
Space: O(n)
'''

class Solution:
    def deleteDuplicatesUnsorted(self, head: ListNode) -> ListNode:
        m = {}
        cur = head
        while cur != None:
            val = cur.val
            if val in m:
                m[val] += 1
            else:
                m[val] = 1
            cur = cur.next
        res = ListNode(-1)
        prev = res
        cur = head
        while cur != None:
            val = cur.val
            if m[val] < 2:
                res.next = ListNode(val)
                res = res.next
            cur = cur.next
        return prev.next