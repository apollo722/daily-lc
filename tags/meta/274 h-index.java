/*
https://leetcode.com/problems/h-index/

可以排序之后二分查找
也可以直接用桶排序的思路，统计每个citation出现的频率
因为最大的h idx不会超过paper总数n，所以统计citation频率时用n作为cap即可
之后n开始扫描，当某一时刻citation大于等于res的总量大于等于res的时候即为答案

Time: O(n)
Space: O(n)
*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c : citations) papers[Math.min(n, c)]++;
        int res = n;
        for (int i = papers[n]; res > i; i += papers[res]) res--;
        return res;
    }
}