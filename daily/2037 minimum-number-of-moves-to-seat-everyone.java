/*
https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

可以nlogn排序，也可以桶排序加速

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}