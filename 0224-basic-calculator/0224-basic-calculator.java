class Solution {
    int idx = 0;
    public int calculate(String s) {
        char ops = '+';
        int curSum = 0, prev = 0, res = 0;
        int n = s.length();
        for ( ; idx < n; idx++) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                curSum = 10 * curSum + c - '0';
            } 
            if (c == '(') {
                idx++;
                curSum = calculate(s);
            } 
            if ((!Character.isDigit(c) && c != ' ') || idx == n - 1) {
                if (ops == '+') {
                    res += prev;
                    prev = curSum;
                } else {
                    res += prev;
                    prev = -curSum;
                }
                curSum = 0;
                ops = c;
            }
            if (c == ')') break;
        }
        return res + prev;
    }
}