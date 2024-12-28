/*
https://leetcode.com/problems/filling-bookcase-shelves/

题目要求一定要按顺序摆放，那么摆第i本书的时候能不能根据之前i-1本知道结果呢
需要知道第i本书跟哪些书在一层，因为按顺序摆，所以可以从后往前，包括它自己也可自己在一层
直到装不下为止，扫描的时候直到本层最高的书是什么，那么截止的时候，即j-i都在一层，最高是maxHeight
那么当前的结果就是j-1时的结果+maxHeight
据此就可以dp计算

Time: O(n^2)
Space: O(n)
*/

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int thickness = 0;
            int maxHeight = books[i - 1][1];
            for (int j = i; j > 0; j--) {
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                thickness += books[j - 1][0];
                if (thickness > shelfWidth) break;
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
            }
        }
        return dp[n];
    }
}