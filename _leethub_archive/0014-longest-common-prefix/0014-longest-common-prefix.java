class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];
        String res = getCommon(strs[0], strs[1]);
        if (res.equals("")) return res;
        for (int i = 1; i < n; i++) {
            res = getCommon(strs[i], res);
            if (res.equals("")) return res;
        }
        return res;
    }

    private String getCommon(String a, String b) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            if (i >= a.length()) break;
            if (a.charAt(i) == b.charAt(i)) res.append(b.charAt(i));
            else break;
        }
        return res.toString();
    }
}