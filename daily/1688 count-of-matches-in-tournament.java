/*
https://leetcode.com/problems/count-of-matches-in-tournament/

模拟即可，需要logn
也可以按照逻辑直接返回n-1，因为n支队伍最后只有一个胜者，那么最后有n-1支队伍被淘汰就需要n-1场比赛

Time: O(logn)/O(1)
Space: O(1)
*/

class Solution {
    /*
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += n / 2;
            if (n % 2 == 1) {
                res++;
            }
            n /= 2;
        }
        return res;
    }
    */
    public int numberOfMatches(int n) {
        return n - 1;
    }
}