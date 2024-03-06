/*
https://leetcode.com/problems/validate-ip-address/

细节题
Java的细节：'.'是特殊字符，分割需要用'\\.'，且split会自动去掉首尾长度为0的token
故需要check首尾是否为':'

Time: O(n)
Space: O(n)
*/

class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.length() == 0) return "Neither";
        if (queryIP.indexOf('.') != -1) {
            if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') return "Neither";
            String[] arr = queryIP.split("\\.");
            if (arr.length != 4) return "Neither";
            for (String s : arr) {
                if (s.length() == 0 || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) return "Neither";
                int cur = 0;
                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c)) return "Neither";
                    cur = cur * 10 + c - '0';
                }
                if (cur > 255) return "Neither";
            }
            return "IPv4";
        }
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') return "Neither";
        String[] arr = queryIP.split(":");
        if (arr.length != 8) return "Neither";
        for (String s : arr) {
            if (s.length() > 4 || s.length() == 0) return "Neither";
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c) || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F')) continue;
                else return "Neither";
            }
        }
       
        return "IPv6";
    }
}