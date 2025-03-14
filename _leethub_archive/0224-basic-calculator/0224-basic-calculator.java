class Solution {
    int idx = 0;
    public int calculate(String s) {
        char ops = '+';
        int num = 0, prev = 0, res = 0;
        int n = s.length();
        for ( ; idx < n; idx++) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } 
            if (c == '(') {
                idx++;
                num = calculate(s);
            } 
            if ((!Character.isDigit(c) && c != ' ') || idx == n - 1) {
                if (ops == '+') {
                    res += prev;
                    prev = num;
                } else {
                    res += prev;
                    prev = -num;
                }
                num = 0;
                ops = c;
            }
            if (c == ')') break;
        }
        return res + prev;
    }
}