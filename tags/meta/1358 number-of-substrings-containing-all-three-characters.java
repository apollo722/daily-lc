/*
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

sliding window变种
先通过sliding window找到一个满足条件的str，那么从这个str的终点到整个str的结尾的每一个位置都是valid的
即如果[l,r] valid，res+=n-r，即结果包含了所有l起点出的valid str
根据滑动窗口，不断移动窗口左右两侧，在满足条件的str中按上述公式计算即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numberOfSubstrings(String s) {
        int[] m = new int[3];
        int l = 0, r = 0, n = s.length(), cnt = 0, res = 0;
        while (r < n) {
            char c = s.charAt(r);
            if (m[c - 'a']++ == 0) cnt++;
            while (cnt == 3) {
                res += n - r;
                if (--m[s.charAt(l++) - 'a'] == 0) cnt--;
            }
            r++;
        }
        return res;
    }
}