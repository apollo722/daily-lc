/*
https://leetcode.com/problems/destination-city/

计算出度即可，也可以用set记录所有出度大于0的，之后再扫一遍输入找到不在set中的v端(u->v)

Time: O(n)
Space: O(n)
*/

class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> m = new HashMap<>();
        for (List<String> l : paths) {
            String u = l.get(0), v = l.get(1);
            if (!m.containsKey(u)) m.put(u, 0);
            if (!m.containsKey(v)) m.put(v, 0);
            m.put(u, m.get(u) + 1);
        }
        for (String k : m.keySet()) {
            if (m.get(k) == 0) return k;
        }
        return "";
    }
}