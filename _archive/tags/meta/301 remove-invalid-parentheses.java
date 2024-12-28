/*
https://leetcode.com/problems/remove-invalid-parentheses/

最长的valid str一定是去除exact需要删掉的括号留下来的str
所以先统计左括号右括号分别需要删除多少
backtrack过程中优先删除需要删除的，那么剩下的无论怎么选，只要是valid的就一定是最长的
之后通过backtrack处理余下的char

Time: O(2^n)
Space: O(n)，backtrack最深会到depth n

更优化的方法是：
对于每次remove，都只保证remove第一个invalid的括号
保证每次都remove第一个，需要记录上一次remove到哪里，之后从那里开始
所以需要两个变量，一个记录main str中上一次remove的位置
一个记录上一次remove的invalid括号的位置

当处理完当前顺序后，将其反过来再处理一遍即可

最worst的情况还是O(2^n)，因为保证每次只remove第一个invalid括号，这样不用重复处理duplicate，所以大大提高了运行速度
*/

class Solution {
    HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int rmLeft = 0, rmRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') rmLeft++;
            else if (c == ')') {
                if (rmLeft == 0) {
                    rmRight++;
                    continue;
                }
                rmLeft--;
            }
        }
        backtrack(s, 0, 0, 0, rmLeft, rmRight, new StringBuilder());
        return new ArrayList<>(set);
    }

    private void backtrack(String s, int idx, int curLeft, int curRight, int rmLeft, int rmRight, StringBuilder cur) {
        if (s.length() == idx) {
            if (curLeft == curRight) set.add(cur.toString());
            return;
        }
        char c = s.charAt(idx);
        if (rmLeft > 0 || rmRight > 0) {
            if (rmLeft > 0 && c == '(') backtrack(s, idx + 1, curLeft, curRight, rmLeft - 1, rmRight, cur);
            if (rmRight > 0 && c == ')') backtrack(s, idx + 1, curLeft, curRight, rmLeft, rmRight - 1, cur);
        }
        cur.append(c);
        if (c == '(') {
            backtrack(s, idx + 1, curLeft + 1, curRight, rmLeft, rmRight, cur);
        } else if (c == ')') {
            if (curLeft > curRight) backtrack(s, idx + 1, curLeft, curRight + 1, rmLeft, rmRight, cur);
        } else {
            backtrack(s, idx + 1, curLeft, curRight, rmLeft, rmRight, cur);
        }
        cur.deleteCharAt(cur.length() - 1);
    }
}

// 优化方法
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        remove(s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void remove(String s, int lastI, int lastJ, char[] pair) {
        for (int balance = 0, i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) balance++;
            else if (s.charAt(i) == pair[1]) balance--;
            if (balance >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == lastJ || s.charAt(j - 1) != pair[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, pair);
                }
            }
            return;
        }
        String revStr = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') remove(revStr, 0, 0, new char[]{')', '('});
        else res.add(revStr);
    }
}