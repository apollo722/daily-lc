class Solution {
    public boolean isNumber(String s) {
        boolean hasDigit = false, hasExp = false, hasDot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) hasDigit = true;
            else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (c == '.') {
                if (hasDot || hasExp) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasExp || !hasDigit) return false;
                hasExp = true;
                hasDigit = false;
            } else return false;
        }
        return hasDigit;
    }
}