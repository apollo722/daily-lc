class Solution {
    static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }
        backtrack(digits, new StringBuilder(), 0, res);
        return res;
    }

    private void backtrack(String s, StringBuilder cur, int idx, List<String> res) {
        if (idx == s.length()) {
            res.add(cur.toString());
            return;
        }
        char c = s.charAt(idx);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            cur.append(str.charAt(i));
            backtrack(s, cur, idx + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}