/*
https://leetcode.com/problems/stickers-to-spell-word/

因为target length不大，所以可以暴力求解找到所有可能的组合
总共有2^n个组合，只需要看每个组合需要的最小sticker数即可
有更优化的利用BFS的解法：https://leetcode.com/problems/stickers-to-spell-word/solutions/962702/java-4-ms-100-bfs-explanation-and-complexity-analysis/

Time: O(2^n s n l)，n为target length，s为number of sticker，l为average sticker length
Space: O(2^n)
*/

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = (1 << target.length());
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String s : stickers) {
                int nextState = getState(i, s, target);
                dp[nextState] = Math.min(dp[nextState], dp[i] + 1);
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

    private int getState(int curState, String s, String target) {
        int n = target.length();
        for (char c : s.toCharArray()) {
            for (int i = 0; i < n; i++) {
                if ((curState & (1 << i)) != 0) continue;
                char t = target.charAt(i);
                if (c == t) {
                    curState |= (1 << i);
                    break;
                }
            }
        }
        return curState;
    }
}