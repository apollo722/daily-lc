'''
https://leetcode.com/problems/count-substrings-without-repeating-character/

sliding window模板
注意结果是累加的即可

Time: O(n)
Space: O(1)
'''

class Solution:
    def numberOfSpecialSubstrings(self, s: str) -> int:
        res = 0
        l = 0
        m = [0] * 26
        for r in range(len(s)):
            m[ord(s[r]) - ord("a")] += 1
            while m[ord(s[r]) - ord("a")] > 1:
                m[ord(s[l]) - ord("a")] -= 1
                l += 1
            res += r - l + 1
        return res