/*
https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/

如果没有S，或者有奇数个S，那么一定无法分配，返回0
每次扫描两个S（称为一对），那么一对的第一个S和之前一对的后一个S之间有多少空隙，就有多少个分配方式

S P P S -> 3

所以只需要顺序扫描，每次都找一对S，之后记录前一个S的index并累乘逐个计算
最后只要剔除奇数个S和没有S的情况即可

Time: O(n)
Space: O(1)
*/

class Solution {
    int mod = 1_000_000_007;
    public int numberOfWays(String corridor) {
        long res = 1;
        int seat = 0;
        Integer prev = null;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seat++;
                if (seat == 2) {
                    prev = i;
                    seat = 0;
                } else if (seat == 1 && prev != null) {
                    res *= i - prev;
                    res %= mod;
                }
            }
        }
        if (seat == 1 || prev == null) return 0;
        return (int) res;
    }
}