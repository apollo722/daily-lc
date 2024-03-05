/*
https://leetcode.com/problems/fruit-into-baskets/

用sliding window可做，且也是O(1) space，因为hashmap占用k-v pair的空间，而此题map最大为3
也可以用常量来代替map，即时刻追踪当前总量和上一个和当前元素不同类的个数
如果一个元素属于任何一个bk，那么总量++，否则记录下当下最大的结果，并把当前的总量重置为上一个不同元素的数量+1
这是因为我们要摒弃再往前的一个不同元素，那么当前总量即为上一个不同元素的个数+新的这一个元素
如果这个元素和记录的前一个元素一样，那么前一个元素总和++
否则要换一下，即前前变成前，前变成当下，也要重置前一个元素为个数为1，因为前是当下遇到的第一个元素，自然只有1个

Time: O(n)
Space: O(1)
*/

class Solution {
    public int totalFruit(int[] fruits) {
        int bk1 = -1, bk2 = -1, prevCnt = 0, res = 0, cur = 0;
        for (int num : fruits) {
            if (num == bk1 || num == bk2) cur++;
            else {
                res = Math.max(res, cur);
                cur = prevCnt + 1;
            }
            if (num == bk1) prevCnt++;
            else {
                prevCnt = 1;
                bk2 = bk1;
                bk1 = num;
            }
        }
        return Math.max(cur, res);
    }
}