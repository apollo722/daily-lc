/*
https://leetcode.com/problems/string-compression-ii/

top down dp，记录每个位置可以delete k个字符的结果，并找到最小值
在每个位置，都有删或者不删两种选择，结果要取二者中较小值
删掉的情况比较简单，就继续check下一个位置并减少k即可
如果决定不删除当前的位置，那么就意味着要将当前位置的字符尽量的压缩
即计算当前压缩后的长度：统计cnt数，在cnt=1，2，10，100时，length++
当碰到第一个与当前字符不同的字符时，要面临一个抉择，即要不要删除这个遇到的新字符
这应该是为了考虑"aabbaa"这个情况，即删除后前面和后面相同的字符合并了
所以，如果遇到了不同的字符，要保留可以删掉它可能，即calc(i+1, k-diff)
这里k-diff即意味着遇到的不同的字符都删掉了，之后后续的交给后米的recursive call来解决
比如"aabbaa"，calc(3, 1)，即查的是"baa"，因为上一步计算"aab"时的length是2，而不是3，即没有考虑最后的b
相当于已经删掉了第一个遇到的不同于a的字符，b
所以下一步是calc(3,1)而不是calc(3,2)

Time: O(nk^2)，inner loop最多也不会超过k次
Space: O(nk)
*/

class Solution {
    private int[][] memo;
    private char[] arr;
    private int n;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        this.arr = s.toCharArray();
        this.n = s.length();
        this.memo = new int[n][k + 1];
        for (int[] d : memo) {
            Arrays.fill(d, -1);
        }
        return calc(0, k);
    }
    
    private int calc(int idx, int k) {
        if (k < 0) return n;
        if (idx + k >= n) return 0;
        if (memo[idx][k] != -1) return memo[idx][k];
        int res = calc(idx + 1, k - 1);
        int length = 0, cnt = 0, diff = 0;
        for (int i = idx; i < n && diff <= k; i++) {
            if (arr[i] == arr[idx]) {
                cnt++;
                if (cnt <= 2 || cnt == 10 || cnt == 100) length++;
            } else {
                diff++; 
            }
            res = Math.min(res, length + calc(i + 1, k - diff)); 
        }
        memo[idx][k] = res;
        return res;
    }
}