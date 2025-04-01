class Solution {
    public int minSteps(String s, String t) {
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            m[sc - 'a']++;
            m[tc - 'a']--;
        }
        int res = 0;
        for (int num : m) {
            if (num > 0) res += num;
        }
        return res;
    }
}