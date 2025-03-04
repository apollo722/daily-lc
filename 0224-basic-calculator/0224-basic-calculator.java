class Solution {
    int idx = 0;
    public int calculate(String s) {
        char ops = '+';
        int curSum = 0, prev = 0, res = 0;
        int n = s.length();
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
                curSum = 10 * curSum + c - '0';
            } else if (c == '(') {
               curSum = calculate(s);
            } else if (c == ')') break;
            else {
                if (ops == '+') {
                    res += curSum;
                } else res -= curSum;
                curSum = 0;
                ops = c;
            }
        }
        if (ops == '+') {
            res += curSum;
        } else res -= curSum;
        return res;
    }
}