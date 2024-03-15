/*
https://leetcode.com/problems/goat-latin/

完全模拟，考察一遍过的能力

Time: O(n)
Space: O(n)
*/

class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder res = new StringBuilder();
        String vowels = "aeiouAEIOU";
        int cnt = 1;
        for (String s : sentence.split(" ")) {
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i == 0 && vowels.indexOf(c) != -1) {
                    flag = true;
                } else if (i == 0) continue;
                res.append(c);
            }
            if (!flag) res.append(s.charAt(0));
            res.append("ma");
            for (int i = 0; i < cnt; i++) res.append('a');
            res.append(' ');
            cnt++;
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}