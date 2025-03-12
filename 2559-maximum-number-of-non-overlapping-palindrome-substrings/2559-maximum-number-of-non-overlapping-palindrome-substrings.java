class Solution {
    public int maxPalindromes(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = (j - i) + 1;
                if ((len == k || len == k + 1) && isPalindrome(s, i, j)) {
                    res++;
                    i = j;
                    break;
                }
            }
        }
        
        return res;
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}