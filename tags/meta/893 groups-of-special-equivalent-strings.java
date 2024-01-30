/*
https://leetcode.com/problems/groups-of-special-equivalent-strings/

奇偶idx的char组成array后分别排序再组合作为key即可

Time: O(nmlogm)
Space: O(n)
*/

class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(process(w));
        }
        return set.size();
    }

    public String process(String s) {
        StringBuilder res = new StringBuilder();
        List<Character> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) even.add(s.charAt(i));
            else odd.add(s.charAt(i));
        }
        Collections.sort(odd);
        Collections.sort(even);
        for (char c : odd) res.append(c);
        for (char c : even) res.append(c);
        return res.toString();
    }
}