/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

模板backtracking

Time: O(n 4^n)，假设只有7和9，共n个位置每个位置有4中选择
Space: O(n)
*/

class Solution {
    HashMap<Character, String> m = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder cur) {
        if (idx == digits.length()) {
            if (cur.length() != 0) res.add(cur.toString());
            return;
        }
        char c = digits.charAt(idx);
        for (char p : m.get(c).toCharArray()) {
            cur.append(p);
            backtrack(digits, idx + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}