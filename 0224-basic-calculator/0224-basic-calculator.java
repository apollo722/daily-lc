class Solution {
    public int calculate(String s) {
        char ops = '+';
        int curSum = 0, prev = 0, res = 0;
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i++);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
                curSum = 10 * curSum + c - '0';
            } else if (c == '(') {
                int j = i, balance = 1;
                while (balance > 0) {
                    if (s.charAt(j) == '(') balance++;
                    else if (s.charAt(j) == ')') balance--;
                    j++;
                }
                curSum += calculate(s.substring(i, j));
                i = j;
            } else {
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