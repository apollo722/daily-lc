/*
https://leetcode.com/problems/rotated-digits/

每个数字检查一遍
如果数字中还有347直接不符合
如果有2569保留有符合的希望
如果有剩下的018还不一定，因为如果都是018那反转过后并不是不同的数字

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i) > 0) res++;
        }
        return res;
    }

    private int check(int num) {
        int res = 0;
        while (num > 0) {
            int d = num % 10;
            if (d == 3 || d == 4 || d == 7) return 0;
            if (d == 2 || d == 5 || d == 6 || d == 9) res++;
            num /= 10;
        }
        return res;
    }
}