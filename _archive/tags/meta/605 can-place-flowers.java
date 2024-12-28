/*
https://leetcode.com/problems/can-place-flowers/

贪心，每个0位置检查左边和右边，如果都没有花，种上
如果一个位置种了花，可以向下多移1位位置，因为下一个位置一定不能种

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0) || flowerbed[i - 1] == 0;
                boolean right = (i == len - 1) || flowerbed[i + 1] == 0;
                if (left && right) {
                    flowerbed[i++] = 1;
                    n--;
                }
            }
            if (n <= 0) return true;
        }
        return n <= 0;
    }
}