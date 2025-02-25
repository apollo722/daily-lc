class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < prev.length()) {
            int count = 0, i = idx;
            while (i < prev.length() && prev.charAt(idx) == prev.charAt(i)) {
                i++;
                count++;
            }
            res.append(count + "");
            res.append(prev.charAt(idx));
            idx = i;
        }
        return res.toString();
    }
}