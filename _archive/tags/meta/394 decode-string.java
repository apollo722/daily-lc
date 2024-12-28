/*
https://leetcode.com/problems/decode-string/

两个stack分别存储cnt和str
每次遇到‘[’就push str和num
每次遇到‘]’就更新curStr，使得它重复pop出来的cnt，并在之前attach pop出来的str
最后的结果即为curStr

Time: O(max(k) n)，k最长int，即str repeat time
Space: O(n)
*/

class Solution {
    public String decodeString(String s) {
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
            } else if (c == '[') {
                numSt.push(curNum);
                curNum = 0;
                strSt.push(curStr.toString());
                curStr = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                String prevStr = strSt.pop();
                int prevNum = numSt.pop();
                tmp.append(prevStr);
                for (int i = 0; i < prevNum; i++) tmp.append(curStr);
                curStr = tmp;
            } else curStr.append(c);
        }
        return curStr.toString();
    }
}