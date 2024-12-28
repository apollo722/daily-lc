class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> convert = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            convert.add(new StringBuilder());
        }
        int r = 0, idx = 0;
        boolean moveDown = true;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            convert.get(r).append(c);
            if (moveDown) {
                r++;
            } else {
                r--;
            }
            if (r == numRows - 1) {
                moveDown = false;
            } else if (r == 0) {
                moveDown = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : convert) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}