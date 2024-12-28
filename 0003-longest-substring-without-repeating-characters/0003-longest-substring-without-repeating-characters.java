class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c));
            }
            res = Math.max(res, r - l);
            map.put(c, r);
        }
        return res;
    }
}


/*
常规的sliding window可解。
可以用更快的sliding window，即在map中存储遇到的字符的下一个index。
这样当遇到重复字符的时候可以直接将窗口左侧移动到当前出现过该字符的右侧，以保证窗口内没有重复字符。
*/