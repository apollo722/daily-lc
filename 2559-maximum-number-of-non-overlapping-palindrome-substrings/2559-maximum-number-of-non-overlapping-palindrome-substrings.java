class Solution {
    public int maxPalindromes(String s, int k) {
    int n = s.length(), res = 0, start = 0;
    for (int center = 0; center < 2 * n; center++) {
        int left = center / 2;
        int right = left + center % 2;
        while (left >= start && right < n && s.charAt(left) == s.charAt(right)) {
            if (right + 1 - left >= k) {
                res++;
                start = right + 1;
                break;
            }
            left--; right++;
        }
    }
    return res;
}
}