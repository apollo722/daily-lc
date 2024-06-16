/*
https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/

代码题，写的细心点
目标分钟更小的话需要进位

Time: O(1)
Space: O(1)
*/

class Solution {
    public int convertTime(String current, String correct) {
        int res = 0;
        int tMin = Integer.valueOf(correct.substring(3, 5));
        int tHour = Integer.valueOf(correct.substring(0, 2));
        int sMin = Integer.valueOf(current.substring(3, 5));
        int sHour = Integer.valueOf(current.substring(0, 2));
        if (tMin > sMin) {
            res += setMin(sMin, tMin);
        } else if (tMin < sMin) {
            sHour += 1;
            res += setMin(sMin, tMin + 60);
        }

        if (tHour >= sHour) return res + tHour - sHour;
        else return res + sHour + 24 - tHour;
    }

    private int setMin(int sMin, int tMin) {
        int res = 0;
        while (tMin > sMin) {
            if (tMin - 15 >= sMin) tMin -= 15;
            else if (tMin - 5 >= sMin) tMin -= 5;
            else tMin -= 1;
            res++;
        }
        return res;
    }
}