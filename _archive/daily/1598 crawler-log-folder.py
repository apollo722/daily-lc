'''
https://leetcode.com/problems/crawler-log-folder/

代码题，按照具体的路径算下最后走的相对距离即可

Time: O(n)
Space: O(1)
'''

class Solution:
    def minOperations(self, logs: List[str]) -> int:
        res = 0
        for item in logs:
            if item == './':
                continue
            elif item == '../':
                res = res - 1 if res > 0 else 0
            else:
                res += 1
        return res