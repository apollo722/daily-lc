'''
https://leetcode.com/problems/find-the-winner-of-the-circular-game/

先看递归怎么做
为了解决(n, k)问题，要先解决(n - 1, k)，等等，解决(1, k)
如果是1的时候，直接返回0
n与n-1所有人的index都减少了k
比如n=4，k=2时，从0开始，index 1的人离开队伍，那么index2的人就变成了index 0，index 3变成了index 1
而index 0变成了index 2（0-2+4）
所以从n-1恢复到n时的index就反过来，即全员+k，当然最后要对n取余数
即f(n, k) = (f(n - 1, k) + k) % n

把递归翻译成循环即反过来，最后剩一个人的时候它的index一定是0
那么当还剩下两个人时，它的index实际上是(index + k) % i，i为当时的人数，即为2
以此类推，反推出结果即可

Time: O(n)
Space: O(1)
'''

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        res = 0
        for i in range(2, n + 1):
            res = (res + k) % i
        return res + 1