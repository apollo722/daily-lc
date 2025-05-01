class Solution {
    public int compress(char[] chars) {
        int n = chars.length, l = 0, r = 0, idx = 0;
        while (l < n) {
            char c = chars[l];
            while (r < n && chars[r] == c) r++;
            int cnt = r - l;
            chars[idx++] = c;
            if (cnt > 1) {
                for (char d : (cnt + "").toCharArray()) chars[idx++] = d;
            }
            l = r;
        }
        return idx;
    }
}