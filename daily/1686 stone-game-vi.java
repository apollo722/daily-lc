/*
https://leetcode.com/problems/stone-game-vi/

贪心，每次玩家选择石头，不仅要选自己这边更大的，也要尽量选对面大的
因为选了一个位置之后对面就不能再选这个位置了
所以可以把所有位置加和后从大到小排序

空间上可以用其中一个输入来存储和，同时记录另一边的和，这样可以用输入作为存储媒介而不用新建2n的数组

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] stones = new int[n][2];
        for (int i = 0; i < n; i++) {
            stones[i] = new int[]{aliceValues[i], bobValues[i]};
        }
        Arrays.sort(stones, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) alice += stones[i][0];
            else bob += stones[i][1];
        }
        if (alice == bob) return 0;
        return alice > bob ? 1 : -1;
    }
}