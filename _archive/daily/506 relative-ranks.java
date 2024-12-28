/*
https://leetcode.com/problems/relative-ranks/

桶排序模板
先记录下每个score对应的idx
之后桶排序从大到小按题意放到结果中即可

Time: O(n + maxNum)
Space: O(maxNum)
*/

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int maxScore = score[0];
        for (int s : score) maxScore = Math.max(maxScore, s);
        int[] idxArr = new int[maxScore + 1];
        Arrays.fill(idxArr, -1);
        for (int i = 0; i < score.length; i++) {
            idxArr[score[i]] = i;
        }
        int place = 0;
        String[] names = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] res = new String[score.length];
        for (int i = maxScore; i >= 0; i--) {
            if (idxArr[i] != -1) {
                int idx = idxArr[i];
                if (place < 3) {
                    res[idx] = names[place];
                } else res[idx] = String.valueOf(place + 1);
                place++;
            }
        }
        return res;
    }
}