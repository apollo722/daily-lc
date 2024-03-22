/*
https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

顺序构建，选越小的越好，但是选的太小了剩下的就填不满了
所以每个位置最小能填什么字符取决于剩下的位置能不能被填满
假设当前填cur，那么余下的位置最大可以消耗(n-i)*26，所以当前k-cur需要<=(n-i)*26，即cur>=k-(n-i)*26
cur最小是1('a')，所以每个位置的cur=Math.max(k-(n-i)*26,1)

Time: O(n)
Space: O(1)
*/

class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for (int i = 1; i <= n; i++) {
            int cur = Math.max(k - (n - i) * 26, 1);
            k -= cur;
            res[i - 1] = (char)('a' + cur - 1);
        }
        return new String(res);
    }
}