/*
https://leetcode.com/problems/number-of-wonderful-substrings/

总共只有十个字母，可以用mask，每个位置代表一个字母
只有最多一个字母是奇数个，利用bit运算，所有字母异或起来最多只有一位是1
所以每遇到一个字符，就异或上mask，如果又一次见到同样的mask，即map中出现过
那说明当前字符与之前出现过该字符位置之间的substr的各字符出现次数都是偶数
最后再计算哪个字符存在奇数次即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        int[] freq = new int[1024];
        freq[0] = 1;
        int mask = 0;
        long res = 0L;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int bitPos = c - 'a';
            mask ^= (1 << bitPos);
            res += freq[mask];
            freq[mask]++;
            for (int j = 0; j < 10; j++) {
                res += freq[mask ^ (1 << j)];
            }
        }
        return res;
    }
}