class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int idx1 = -1, idx2 = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) {
                cnt++;
                if (cnt > 2) return false;
                if (cnt == 1) idx1 = i;
                else idx2 = i;
            }
        }
        if (cnt == 0) return true;
        if (cnt == 1) return false;
        return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
    }
}