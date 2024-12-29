class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int res = 0, idx = 0, n = s.length();
        while (idx < n) {
            if (idx + 1 < n) {
                String checkStr = s.substring(idx, idx + 2);
                if (map.containsKey(checkStr)) {
                    res += map.get(checkStr);
                    idx += 2;
                    continue;
                }
            }
            res += map.get(s.substring(idx, idx + 1));
            idx++;
        }
        return res;
    }
}