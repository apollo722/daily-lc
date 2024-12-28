/*
https://leetcode.com/problems/expression-add-operators/

backtrack模板
每一个位置都可以组成数字，或者添加运算符
需要记录每一个位置当前能组成的数字
如果后面添加+/-，那么前一个数字直接加到结果中
如果是*，需要把之前数字从结果中抹去再加上乘积的结果
需要额外判断当前数字没有leading 0

Time: O(n 4^n)，每个字符可以组成数字，也可以添加三个不同的运算符，额外的n是用来组成str的
Space: O(n)
*/

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        solve(num, 0, 0, 0, target, "");
        return res;
    }

    private void solve(String s, int idx, long resNum, long prevNum, int tar, String curStr) {
        if (s.length() == idx) {
            if (resNum == tar) {
                res.add(curStr);
            }
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0') return;
            long curNum = Long.parseLong(s.substring(idx, i + 1));
            if (idx == 0) {
                solve(s, i + 1, curNum, curNum, tar, curStr + curNum);
            } else {
                solve(s, i + 1, resNum + curNum, curNum, tar, curStr + "+" + curNum);
                solve(s, i + 1, resNum - curNum, -curNum, tar, curStr + "-" + curNum);
                solve(s, i + 1, resNum - prevNum + prevNum * curNum, prevNum * curNum, tar, curStr + "*" + curNum);
            }
        }
    }
}