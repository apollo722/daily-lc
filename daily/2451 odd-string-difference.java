/*
https://leetcode.com/problems/odd-string-difference/

把所有单词都转化成以a开头的，如果某一个单词转化完之后和前一个不同，那么下一个和谁不同，谁就是答案
很多种思路但是大同小异，这里用map存一下转换后的str出现了几次，一旦出现超过两次那它就是标杆，和它不同就是答案
如果到最后都没找到，那答案一定是第一或第二个str，他俩的转换后str在map中频率是1的即为答案

Time: O(n)
Space: O(1)
*/

class Solution {
    public String oddString(String[] words) {
        int n = words.length, len = words[0].length();
        HashMap<String, Integer> m =  new HashMap<>();
        String others = "";
        for (String w : words) {
            String convert = convert(w);
            if (others.length() > 0 && !convert.equals(others)) return w;
            m.put(convert, m.getOrDefault(convert, 0) + 1);
            if (others.length() == 0 && m.get(convert) > 1) {
                others = convert;
            }
        }
        if (m.get(convert(words[0])) == 1) return words[0];
        return words[1];
    }

    private String convert(String s) {
        int n = s.length(), diff = s.charAt(0) - 'a';
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            char next = (char)(c - diff);
            if (next < 'a') next += 26;
            res.append(next);
        }
        return res.toString();
    }
}