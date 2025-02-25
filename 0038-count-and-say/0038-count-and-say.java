class Solution {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        res.append("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < res.length(); ) {
                char c = res.charAt(j);
                int k = j; 
                while (k < res.length() && res.charAt(j) == res.charAt(k)) k++;
                cur.append(k - j + "");
                cur.append(c);
                j = k;
            }
            res = cur;
        }
        return res.toString();
    }
}