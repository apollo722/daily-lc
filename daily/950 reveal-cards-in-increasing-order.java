/*
https://leetcode.com/problems/reveal-cards-in-increasing-order/

在原数组的位置，每隔1个位置填一个数
比如1,2,3,4,5,6,7,8
1_2_3_4_
 5 _ 6 _
   7   8
如果一个位置已经有数了，就跳过找下一个空位
直到都填满

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length, i = 0, cur = 0;
        int[] res = new int[n];
        boolean skip = false;
        while (cur < n) {
            if (res[i] == 0) {
                if (!skip) {
                    res[i] = deck[cur++];
                }
                skip = !skip;
            }
            i = (i + 1) % n;
        }
        return res;
    }
}