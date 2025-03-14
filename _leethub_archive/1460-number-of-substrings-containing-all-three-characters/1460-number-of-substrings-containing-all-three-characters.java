class Solution {
    public int numberOfSubstrings(String s) {
        int[] m = new int[3];
        int res = 0, cnt = 0, l = 0, r = 0, n = s.length();
        while (r < n) {
            char rc = s.charAt(r);
            if (++m[rc - 'a'] == 1) cnt++;
            while(cnt == 3) {
                res += n - r;
                char lc = s.charAt(l++);
                if (--m[lc - 'a'] == 0) cnt--;
            }
            r++;
        }
        return res;
    }
}