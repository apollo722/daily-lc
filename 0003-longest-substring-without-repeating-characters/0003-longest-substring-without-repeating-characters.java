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