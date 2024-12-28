/*
https://leetcode.com/problems/angle-between-hands-of-a-clock/

分别计算分针时针对0的夹角
时针每格360/12度，分针每格360/60度
分针每走一分钟时针还要多转360/12/60度

Time: O(1)
Space: O(1)
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour -= 12;
        double hourAngle = 360 / 12 * hour + (360 / 12) * 1.0 / 60 * minutes;
        double minuteAngle = 360 / 60 * minutes;
        double res = Math.abs(minuteAngle - hourAngle);
        return res >= 180 ? 360 - res : res;
    }
}