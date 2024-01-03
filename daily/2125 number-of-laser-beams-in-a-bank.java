/*
https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

每次找到下一个含有1的位置并计算含1乘积即可

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length, res = 0, i = 0, j = 0, curCnt = 0, prevCnt = -1;
        int[] m = new int[n];
        while (i < n) {
            if (prevCnt == -1) {
                prevCnt = calc(bank[i]);
            };
            j = i + 1;
            while (j < n) {
                curCnt = calc(bank[j]);
                if (curCnt > 0) {
                    res += prevCnt * curCnt;
                    prevCnt = curCnt;
                    break;
                }
                j++;
            }
            i = j;
        }
        return res;
    }

    private int calc(String s) {
        int res = 0;
        for (char c : s.toCharArray()) res += c == '1' ? 1 : 0;
        return res;
    }
}