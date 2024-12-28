/*
https://leetcode.com/problems/count-and-say/

按照要求循环即可
每次固定一个char之后找到所有和它相同的char，并统计个数
之后根据char和个数构造str，再进行下一轮

Time: ?
Space: ?
*/

class Solution {
    public String countAndSay(int n) {
        String curStr = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            for (int j = 0, k = 0; j < curStr.length(); j = k) {
                char c = curStr.charAt(j);
                while (k < curStr.length() && c == curStr.charAt(k)) k++;
                next.append(String.valueOf(k - j) + c);
            }
            curStr = next.toString();
        }
        return curStr;
    }
}