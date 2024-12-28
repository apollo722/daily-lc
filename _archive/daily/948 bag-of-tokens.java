/*
https://leetcode.com/problems/bag-of-tokens/

排序后从左侧得分，右侧拿power，直到做不到为止
每次先拿分后拿power，即贪心

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1, score = 0;
        while (l <= r) {
            if (power >= tokens[l]) {
                score++;
                power -= tokens[l];
                l++;
            } else if (l < r && score > 0) {
                score--;
                power += tokens[r];
                r--;
            } else return score;
        }
        return score;
    }
}