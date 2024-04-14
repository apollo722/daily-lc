/*
https://leetcode.com/problems/water-bottles-ii/

代码题，按题意模拟

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles, curEmpty = numBottles;
        while (curEmpty >= numExchange) {
            curEmpty -= numExchange;
            numExchange++;
            res++;
            curEmpty++;
        }
        return res;
    }
}