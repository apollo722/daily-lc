/*
https://leetcode.com/problems/different-ways-to-add-parentheses/

每一个运算符两边都会产生一套结果，利用递归把每个运算符两边的str都计算出来
之后两两组合放入结果即可

Time: O(n^3 x^2)，x为number of ways to calculate
Space: O(n^2 x)
*/

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (c == '+') {
                            res.add(left.get(j) + right.get(k));
                        } else if (c == '-') {
                            res.add(left.get(j) - right.get(k));
                        } else if (c == '*') {
                            res.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }
        return res.size() == 0 ? Arrays.asList(Integer.valueOf(expression)) : res;
    }
}