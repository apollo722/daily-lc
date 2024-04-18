/*
https://leetcode.com/problems/guess-number-higher-or-lower/

二分查找模板

Time: O(logn)
Space: O(1)
*/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}