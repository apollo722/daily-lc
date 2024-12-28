/*
https://leetcode.com/problems/group-shifted-strings/

先把每个str都移动到基准以a开始的str，之后在用map group
注意shift时小于a的char要加26以保证落在a-z之间

Time: O(nk)，k是average str length
Space: O(nk)
*/

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> m = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strings) {
            String shifted = getShift(s);
            if (!m.containsKey(shifted)) m.put(shifted, new ArrayList<>());
            m.get(shifted).add(s);
        }
        for (String k : m.keySet()) res.add(m.get(k));
        return res;
    }

    private String getShift(String s) {
        if (s.length() == 0) return "";
        int diff = s.charAt(0) - 'a';
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            char newC = (char) (c - diff);
            if (newC < 'a') newC += 26;
            res.append(newC);
        }
        return res.toString();
    }
}