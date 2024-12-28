class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0, start = -1;
        for (int i = 0; i < n; i++) {
            int[] r1 = check(s, i, i);
            int[] r2 = check(s, i, i + 1);
            if (r1[1] > len) {
                len = r1[1];
                start = r1[0];
            }
            if (r2[1] > len) {
                len = r2[1];
                start = r2[0];
            }
        }
        return s.substring(start, start + len);
    }

    private int[] check(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else break;
        }
        return new int[]{l + 1, r - l - 1};
    }
}