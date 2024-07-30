/*
https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

如果知道了截止至i位置需要删除x个，那么对于i+1位置
如果它是a，有两种选择，如果保留它，那么它左边的所有b都要被删除
如果删掉它，那么当前删除的个数就是x+1
所以就是个小的dp问题
遇到b的时候，统计b的个数
否则，看是删掉a更划算还是删掉b更划算

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumDeletions(String s) {
        int cb = 0, res = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a') {
                res = Math.min(res + 1, cb);
            } else {
                cb++;
            }
        }
        return res;
    }
}